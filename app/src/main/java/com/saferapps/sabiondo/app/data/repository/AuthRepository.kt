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
}