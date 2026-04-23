package com.saferapps.sabiondo.app.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().reference

    suspend fun login(email: String, password: String): AuthResult {

        val result = auth
            .signInWithEmailAndPassword(email, password)
            .await()

        val user = result.user ?: throw Exception("User null")

        val snapshot = database
            .child("Users")
            .child(user.uid)
            .get()
            .await()

        val role = snapshot
            .child("role")
            .getValue(String::class.java)

        val name = user.displayName ?: "Jugador"

        return AuthResult(
            uid = user.uid,
            name = name,
            role = role
        )
    }

    suspend fun register(email: String, password: String, username: String, role: String): AuthResult {
        val result = auth
            .createUserWithEmailAndPassword(email, password)
            .await()

        val firebaseUser = result.user ?: throw Exception("User null")
        val uid = firebaseUser.uid

        // Update profile display name
        val profileUpdates = com.google.firebase.auth.UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()
        firebaseUser.updateProfile(profileUpdates).await()

        // Save to Database
        val userMap = HashMap<String, Any>()
        userMap["uId"] = uid
        userMap["userName"] = username
        userMap["mail"] = email
        userMap["role"] = role

        database.child("Users").child(uid).setValue(userMap).await()

        return AuthResult(
            uid = uid,
            name = username,
            role = role
        )
    }

    suspend fun signInWithGoogle(idToken: String, role: String): AuthResult {
        val credential = com.google.firebase.auth.GoogleAuthProvider.getCredential(idToken, null)
        val result = auth.signInWithCredential(credential).await()
        val user = result.user ?: throw Exception("Google User null")

        // Check if user exists in database, if not, create them
        val snapshot = database.child("Users").child(user.uid).get().await()
        var userRole = role

        if (!snapshot.exists()) {
            val userMap = HashMap<String, Any>()
            userMap["uId"] = user.uid
            userMap["userName"] = user.displayName ?: "Jugador"
            userMap["mail"] = user.email ?: ""
            userMap["role"] = role
            database.child("Users").child(user.uid).setValue(userMap).await()
        } else {
            userRole = snapshot.child("role").getValue(String::class.java) ?: role
        }

        return AuthResult(
            uid = user.uid,
            name = user.displayName ?: "Jugador",
            role = userRole
        )
    }

    suspend fun sendPasswordResetEmail(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }
}