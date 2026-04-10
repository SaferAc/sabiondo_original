package com.saferapps.sabiondo.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsPreferences {

    public static final String PLAYER_NAME = "player_name";
    public static final String LAST_UPDATE_SCORE = "last_update_score";
    public static final String LISTQUIZ = "listquiz";
    public static final String SETTING_Quiz_PREF = "setting_quiz_pref";
    private static final String SOUND_ONOFF = "sound_enable_disable";

    private static final String SHOW_MUSIC_ONOFF = "showmusic_enable_disable";

    private static final String LANG = "language_enable_disable";

    private static final String VIBRATION = "vibrate_status";

    private static final String SCHOOL_GRADE = "school_grade";

    public static final String TOTAL_SCORE = "total_score";

    private static final String POINT = "no_of_point";
    //represneta el sexto grado para no borrar los niveles que ya tenian los usuarios
    public static final String LEVEL_COMPLETED = "level_completed";
    private static final String LEVEL_COMPLETED_2 = "level_completed_2";
    private static final String LEVEL_COMPLETED_3 = "level_completed_3";
    private static final String LEVEL_COMPLETED_4 = "level_completed_4";
    private static final String LEVEL_COMPLETED_5 = "level_completed_5";
    private static final String LEVEL_COMPLETED_1 = "level_completed_1";
    private static final String SCORE_LEVEL_1_1 =  "score_level_1_1";
    private static final String SCORE_LEVEL_1_2 =  "score_level_1_2";
    private static final String SCORE_LEVEL_1_3 =  "score_level_1_3";
    private static final String SCORE_LEVEL_1_4 =  "score_level_1_4";
    private static final String SCORE_LEVEL_1_5 =  "score_level_1_5";
    private static final String SCORE_LEVEL_1_6 =  "score_level_1_6";
    private static final String SCORE_LEVEL_1_7 =  "score_level_1_7";
    private static final String SCORE_LEVEL_1_8 =  "score_level_1_8";
    private static final String SCORE_LEVEL_1_9 =  "score_level_1_9";
    private static final String SCORE_LEVEL_1_10 = "score_level_1_10";
    private static final String SCORE_LEVEL_1_11 = "score_level_1_11";
    private static final String SCORE_LEVEL_1_12 = "score_level_1_12";
    private static final String SCORE_LEVEL_1_13 = "score_level_1_13";
    private static final String SCORE_LEVEL_1_14 = "score_level_1_14";
    private static final String SCORE_LEVEL_1_15 = "score_level_1_15";
    private static final String SCORE_LEVEL_1_16 = "score_level_1_16";
    private static final String SCORE_LEVEL_1_17 = "score_level_1_17";
    private static final String SCORE_LEVEL_1_18 = "score_level_1_18";
    private static final String SCORE_LEVEL_1_19 = "score_level_1_19";
    private static final String SCORE_LEVEL_1_20 = "score_level_1_20";
    private static final String SCORE_LEVEL_1_21 = "score_level_1_21";
    private static final String SCORE_LEVEL_1_22 = "score_level_1_22";
    private static final String SCORE_LEVEL_1_23 = "score_level_1_23";
    private static final String SCORE_LEVEL_1_24 = "score_level_1_24";
    private static final String SCORE_LEVEL_1_25 = "score_level_1_25";
    private static final String SCORE_LEVEL_1_26 = "score_level_1_26";
    private static final String SCORE_LEVEL_1_27 = "score_level_1_27";
    private static final String SCORE_LEVEL_1_28 = "score_level_1_28";
    private static final String SCORE_LEVEL_1_29 = "score_level_1_29";
    private static final String SCORE_LEVEL_1_30 = "score_level_1_20";
    private static final String SCORE_LEVEL_1_31 = "score_level_1_31";
    private static final String SCORE_LEVEL_1_32 = "score_level_1_32";
    private static final String SCORE_LEVEL_1_33 = "score_level_1_33";
    private static final String SCORE_LEVEL_1_34 = "score_level_1_34";
    private static final String SCORE_LEVEL_1_35 = "score_level_1_35";
    private static final String SCORE_LEVEL_1_36 = "score_level_1_36";
    private static final String SCORE_LEVEL_1_37 = "score_level_1_37";
    private static final String SCORE_LEVEL_1_38 = "score_level_1_38";
    private static final String SCORE_LEVEL_1_39 = "score_level_1_39";
    private static final String SCORE_LEVEL_1_40 = "score_level_1_30";
    private static final String SCORE_LEVEL_1_41 = "score_level_1_41";
    private static final String SCORE_LEVEL_1_42 = "score_level_1_42";
    private static final String SCORE_LEVEL_1_43 = "score_level_1_43";
    private static final String SCORE_LEVEL_1_44 = "score_level_1_44";
    private static final String SCORE_LEVEL_1_45 = "score_level_1_45";
    private static final String SCORE_LEVEL_1_46 = "score_level_1_46";
    private static final String SCORE_LEVEL_1_47 = "score_level_1_47";
    private static final String SCORE_LEVEL_1_48 = "score_level_1_48";
    private static final String SCORE_LEVEL_1_49 = "score_level_1_49";
    private static final String SCORE_LEVEL_1_50 = "score_level_1_50";
    private static final String SCORE_LEVEL_1_51 = "score_level_1_51";
    private static final String SCORE_LEVEL_1_52 = "score_level_1_52";
    private static final String SCORE_LEVEL_1_53 = "score_level_1_53";
    private static final String SCORE_LEVEL_1_54 = "score_level_1_54";
    private static final String SCORE_LEVEL_1_55 = "score_level_1_55";
    private static final String SCORE_LEVEL_1_56 = "score_level_1_56";
    private static final String SCORE_LEVEL_1_57 = "score_level_1_57";
    private static final String SCORE_LEVEL_1_58 = "score_level_1_58";
    private static final String SCORE_LEVEL_1_59 = "score_level_1_59";
    private static final String SCORE_LEVEL_1_60 = "score_level_1_70";
    private static final String SCORE_LEVEL_1_61 = "score_level_1_71";
    private static final String SCORE_LEVEL_1_62 = "score_level_1_72";
    private static final String SCORE_LEVEL_1_63 = "score_level_1_73";
    private static final String SCORE_LEVEL_1_64 = "score_level_1_74";
    private static final String SCORE_LEVEL_1_65 = "score_level_1_75";
    private static final String SCORE_LEVEL_1_66 = "score_level_1_76";
    private static final String SCORE_LEVEL_1_67 = "score_level_1_77";
    private static final String SCORE_LEVEL_1_68 = "score_level_1_78";
    private static final String SCORE_LEVEL_1_69 = "score_level_1_79";
    private static final String SCORE_LEVEL_1_70 = "score_level_1_70";
    private static final String SCORE_LEVEL_1_71 = "score_level_1_81";
    private static final String SCORE_LEVEL_1_72 = "score_level_1_82";
    private static final String SCORE_LEVEL_1_73 = "score_level_1_83";
    private static final String SCORE_LEVEL_1_74 = "score_level_1_84";
    private static final String SCORE_LEVEL_1_75 = "score_level_1_85";
    private static final String SCORE_LEVEL_1_76 = "score_level_1_86";
    private static final String SCORE_LEVEL_1_77 = "score_level_1_87";
    private static final String SCORE_LEVEL_1_78 = "score_level_1_88";
    private static final String SCORE_LEVEL_1_79 = "score_level_1_89";
    private static final String SCORE_LEVEL_1_80 = "score_level_1_89";
    private static final String SCORE_LEVEL_1_81 = "score_level_1_81";
    private static final String SCORE_LEVEL_1_82 = "score_level_1_82";
    private static final String SCORE_LEVEL_1_83 = "score_level_1_83";
    private static final String SCORE_LEVEL_1_84 = "score_level_1_84";
    private static final String SCORE_LEVEL_1_85 = "score_level_1_85";
    private static final String SCORE_LEVEL_1_86 = "score_level_1_86";
    private static final String SCORE_LEVEL_1_87 = "score_level_1_87";
    private static final String SCORE_LEVEL_1_88 = "score_level_1_88";
    private static final String SCORE_LEVEL_1_89 = "score_level_1_89";
    private static final String SCORE_LEVEL_1_90 = "score_level_1_90";
    private static final String SCORE_LEVEL_1_91 = "score_level_1_91";
    private static final String SCORE_LEVEL_1_92 = "score_level_1_92";
    private static final String SCORE_LEVEL_1_93 = "score_level_1_93";
    private static final String SCORE_LEVEL_1_94 = "score_level_1_94";
    private static final String SCORE_LEVEL_1_95 = "score_level_1_95";
    private static final String SCORE_LEVEL_1_96 = "score_level_1_96";
    private static final String SCORE_LEVEL_1_97 = "score_level_1_97";
    private static final String SCORE_LEVEL_1_98 = "score_level_1_98";
    private static final String SCORE_LEVEL_1_99 = "score_level_1_99";
    private static final String SCORE_LEVEL_1_100 ="score_level_1_100";
    private static final String SCORE_LEVEL_2_1 =  "score_level_2_1";
    private static final String SCORE_LEVEL_2_2 =  "score_level_2_2";
    private static final String SCORE_LEVEL_2_3 =  "score_level_2_3";
    private static final String SCORE_LEVEL_2_4 =  "score_level_2_4";
    private static final String SCORE_LEVEL_2_5 =  "score_level_2_5";
    private static final String SCORE_LEVEL_2_6 =  "score_level_2_6";
    private static final String SCORE_LEVEL_2_7 =  "score_level_2_7";
    private static final String SCORE_LEVEL_2_8 =  "score_level_2_8";
    private static final String SCORE_LEVEL_2_9 =  "score_level_2_9";
    private static final String SCORE_LEVEL_2_10 = "score_level_2_10";
    private static final String SCORE_LEVEL_2_11 = "score_level_2_11";
    private static final String SCORE_LEVEL_2_12 = "score_level_2_12";
    private static final String SCORE_LEVEL_2_13 = "score_level_2_13";
    private static final String SCORE_LEVEL_2_14 = "score_level_2_14";
    private static final String SCORE_LEVEL_2_15 = "score_level_2_15";
    private static final String SCORE_LEVEL_2_16 = "score_level_2_16";
    private static final String SCORE_LEVEL_2_17 = "score_level_2_17";
    private static final String SCORE_LEVEL_2_18 = "score_level_2_18";
    private static final String SCORE_LEVEL_2_19 = "score_level_2_19";
    private static final String SCORE_LEVEL_2_20 = "score_level_2_20";
    private static final String SCORE_LEVEL_2_21 = "score_level_2_21";
    private static final String SCORE_LEVEL_2_22 = "score_level_2_22";
    private static final String SCORE_LEVEL_2_23 = "score_level_2_23";
    private static final String SCORE_LEVEL_2_24 = "score_level_2_24";
    private static final String SCORE_LEVEL_2_25 = "score_level_2_25";
    private static final String SCORE_LEVEL_2_26 = "score_level_2_26";
    private static final String SCORE_LEVEL_2_27 = "score_level_2_27";
    private static final String SCORE_LEVEL_2_28 = "score_level_2_28";
    private static final String SCORE_LEVEL_2_29 = "score_level_2_29";
    private static final String SCORE_LEVEL_2_30 = "score_level_2_20";
    private static final String SCORE_LEVEL_2_31 = "score_level_2_31";
    private static final String SCORE_LEVEL_2_32 = "score_level_2_32";
    private static final String SCORE_LEVEL_2_33 = "score_level_2_33";
    private static final String SCORE_LEVEL_2_34 = "score_level_2_34";
    private static final String SCORE_LEVEL_2_35 = "score_level_2_35";
    private static final String SCORE_LEVEL_2_36 = "score_level_2_36";
    private static final String SCORE_LEVEL_2_37 = "score_level_2_37";
    private static final String SCORE_LEVEL_2_38 = "score_level_2_38";
    private static final String SCORE_LEVEL_2_39 = "score_level_2_39";
    private static final String SCORE_LEVEL_2_40 = "score_level_2_30";
    private static final String SCORE_LEVEL_2_41 = "score_level_2_41";
    private static final String SCORE_LEVEL_2_42 = "score_level_2_42";
    private static final String SCORE_LEVEL_2_43 = "score_level_2_43";
    private static final String SCORE_LEVEL_2_44 = "score_level_2_44";
    private static final String SCORE_LEVEL_2_45 = "score_level_2_45";
    private static final String SCORE_LEVEL_2_46 = "score_level_2_46";
    private static final String SCORE_LEVEL_2_47 = "score_level_2_47";
    private static final String SCORE_LEVEL_2_48 = "score_level_2_48";
    private static final String SCORE_LEVEL_2_49 = "score_level_2_49";
    private static final String SCORE_LEVEL_2_50 = "score_level_2_50";
    private static final String SCORE_LEVEL_2_51 = "score_level_2_51";
    private static final String SCORE_LEVEL_2_52 = "score_level_2_52";
    private static final String SCORE_LEVEL_2_53 = "score_level_2_53";
    private static final String SCORE_LEVEL_2_54 = "score_level_2_54";
    private static final String SCORE_LEVEL_2_55 = "score_level_2_55";
    private static final String SCORE_LEVEL_2_56 = "score_level_2_56";
    private static final String SCORE_LEVEL_2_57 = "score_level_2_57";
    private static final String SCORE_LEVEL_2_58 = "score_level_2_58";
    private static final String SCORE_LEVEL_2_59 = "score_level_2_59";
    private static final String SCORE_LEVEL_2_60 = "score_level_2_70";
    private static final String SCORE_LEVEL_2_61 = "score_level_2_71";
    private static final String SCORE_LEVEL_2_62 = "score_level_2_72";
    private static final String SCORE_LEVEL_2_63 = "score_level_2_73";
    private static final String SCORE_LEVEL_2_64 = "score_level_2_74";
    private static final String SCORE_LEVEL_2_65 = "score_level_2_75";
    private static final String SCORE_LEVEL_2_66 = "score_level_2_76";
    private static final String SCORE_LEVEL_2_67 = "score_level_2_77";
    private static final String SCORE_LEVEL_2_68 = "score_level_2_78";
    private static final String SCORE_LEVEL_2_69 = "score_level_2_79";
    private static final String SCORE_LEVEL_2_70 = "score_level_2_70";
    private static final String SCORE_LEVEL_2_71 = "score_level_2_81";
    private static final String SCORE_LEVEL_2_72 = "score_level_2_82";
    private static final String SCORE_LEVEL_2_73 = "score_level_2_83";
    private static final String SCORE_LEVEL_2_74 = "score_level_2_84";
    private static final String SCORE_LEVEL_2_75 = "score_level_2_85";
    private static final String SCORE_LEVEL_2_76 = "score_level_2_86";
    private static final String SCORE_LEVEL_2_77 = "score_level_2_87";
    private static final String SCORE_LEVEL_2_78 = "score_level_2_88";
    private static final String SCORE_LEVEL_2_79 = "score_level_2_89";
    private static final String SCORE_LEVEL_2_80 = "score_level_2_89";
    private static final String SCORE_LEVEL_2_81 = "score_level_2_81";
    private static final String SCORE_LEVEL_2_82 = "score_level_2_82";
    private static final String SCORE_LEVEL_2_83 = "score_level_2_83";
    private static final String SCORE_LEVEL_2_84 = "score_level_2_84";
    private static final String SCORE_LEVEL_2_85 = "score_level_2_85";
    private static final String SCORE_LEVEL_2_86 = "score_level_2_86";
    private static final String SCORE_LEVEL_2_87 = "score_level_2_87";
    private static final String SCORE_LEVEL_2_88 = "score_level_2_88";
    private static final String SCORE_LEVEL_2_89 = "score_level_2_89";
    private static final String SCORE_LEVEL_2_90 = "score_level_2_90";
    private static final String SCORE_LEVEL_2_91 = "score_level_2_91";
    private static final String SCORE_LEVEL_2_92 = "score_level_2_92";
    private static final String SCORE_LEVEL_2_93 = "score_level_2_93";
    private static final String SCORE_LEVEL_2_94 = "score_level_2_94";
    private static final String SCORE_LEVEL_2_95 = "score_level_2_95";
    private static final String SCORE_LEVEL_2_96 = "score_level_2_96";
    private static final String SCORE_LEVEL_2_97 = "score_level_2_97";
    private static final String SCORE_LEVEL_2_98 = "score_level_2_98";
    private static final String SCORE_LEVEL_2_99 = "score_level_2_99";
    private static final String SCORE_LEVEL_2_100 ="score_level_2_100";
    private static final String SCORE_LEVEL_3_1 =  "score_level_3_1";
    private static final String SCORE_LEVEL_3_2 =  "score_level_3_2";
    private static final String SCORE_LEVEL_3_3 =  "score_level_3_3";
    private static final String SCORE_LEVEL_3_4 =  "score_level_3_4";
    private static final String SCORE_LEVEL_3_5 =  "score_level_3_5";
    private static final String SCORE_LEVEL_3_6 =  "score_level_3_6";
    private static final String SCORE_LEVEL_3_7 =  "score_level_3_7";
    private static final String SCORE_LEVEL_3_8 =  "score_level_3_8";
    private static final String SCORE_LEVEL_3_9 =  "score_level_3_9";
    private static final String SCORE_LEVEL_3_10 = "score_level_3_10";
    private static final String SCORE_LEVEL_3_11 = "score_level_3_11";
    private static final String SCORE_LEVEL_3_12 = "score_level_3_12";
    private static final String SCORE_LEVEL_3_13 = "score_level_3_13";
    private static final String SCORE_LEVEL_3_14 = "score_level_3_14";
    private static final String SCORE_LEVEL_3_15 = "score_level_3_15";
    private static final String SCORE_LEVEL_3_16 = "score_level_3_16";
    private static final String SCORE_LEVEL_3_17 = "score_level_3_17";
    private static final String SCORE_LEVEL_3_18 = "score_level_3_18";
    private static final String SCORE_LEVEL_3_19 = "score_level_3_19";
    private static final String SCORE_LEVEL_3_20 = "score_level_3_20";
    private static final String SCORE_LEVEL_3_21 = "score_level_3_21";
    private static final String SCORE_LEVEL_3_22 = "score_level_3_22";
    private static final String SCORE_LEVEL_3_23 = "score_level_3_23";
    private static final String SCORE_LEVEL_3_24 = "score_level_3_24";
    private static final String SCORE_LEVEL_3_25 = "score_level_3_25";
    private static final String SCORE_LEVEL_3_26 = "score_level_3_26";
    private static final String SCORE_LEVEL_3_27 = "score_level_3_27";
    private static final String SCORE_LEVEL_3_28 = "score_level_3_28";
    private static final String SCORE_LEVEL_3_29 = "score_level_3_29";
    private static final String SCORE_LEVEL_3_30 = "score_level_3_20";
    private static final String SCORE_LEVEL_3_31 = "score_level_3_31";
    private static final String SCORE_LEVEL_3_32 = "score_level_3_32";
    private static final String SCORE_LEVEL_3_33 = "score_level_3_33";
    private static final String SCORE_LEVEL_3_34 = "score_level_3_34";
    private static final String SCORE_LEVEL_3_35 = "score_level_3_35";
    private static final String SCORE_LEVEL_3_36 = "score_level_3_36";
    private static final String SCORE_LEVEL_3_37 = "score_level_3_37";
    private static final String SCORE_LEVEL_3_38 = "score_level_3_38";
    private static final String SCORE_LEVEL_3_39 = "score_level_3_39";
    private static final String SCORE_LEVEL_3_40 = "score_level_3_30";
    private static final String SCORE_LEVEL_3_41 = "score_level_3_41";
    private static final String SCORE_LEVEL_3_42 = "score_level_3_42";
    private static final String SCORE_LEVEL_3_43 = "score_level_3_43";
    private static final String SCORE_LEVEL_3_44 = "score_level_3_44";
    private static final String SCORE_LEVEL_3_45 = "score_level_3_45";
    private static final String SCORE_LEVEL_3_46 = "score_level_3_46";
    private static final String SCORE_LEVEL_3_47 = "score_level_3_47";
    private static final String SCORE_LEVEL_3_48 = "score_level_3_48";
    private static final String SCORE_LEVEL_3_49 = "score_level_3_49";
    private static final String SCORE_LEVEL_3_50 = "score_level_3_50";
    private static final String SCORE_LEVEL_3_51 = "score_level_3_51";
    private static final String SCORE_LEVEL_3_52 = "score_level_3_52";
    private static final String SCORE_LEVEL_3_53 = "score_level_3_53";
    private static final String SCORE_LEVEL_3_54 = "score_level_3_54";
    private static final String SCORE_LEVEL_3_55 = "score_level_3_55";
    private static final String SCORE_LEVEL_3_56 = "score_level_3_56";
    private static final String SCORE_LEVEL_3_57 = "score_level_3_57";
    private static final String SCORE_LEVEL_3_58 = "score_level_3_58";
    private static final String SCORE_LEVEL_3_59 = "score_level_3_59";
    private static final String SCORE_LEVEL_3_60 = "score_level_3_70";
    private static final String SCORE_LEVEL_3_61 = "score_level_3_71";
    private static final String SCORE_LEVEL_3_62 = "score_level_3_72";
    private static final String SCORE_LEVEL_3_63 = "score_level_3_73";
    private static final String SCORE_LEVEL_3_64 = "score_level_3_74";
    private static final String SCORE_LEVEL_3_65 = "score_level_3_75";
    private static final String SCORE_LEVEL_3_66 = "score_level_3_76";
    private static final String SCORE_LEVEL_3_67 = "score_level_3_77";
    private static final String SCORE_LEVEL_3_68 = "score_level_3_78";
    private static final String SCORE_LEVEL_3_69 = "score_level_3_79";
    private static final String SCORE_LEVEL_3_70 = "score_level_3_70";
    private static final String SCORE_LEVEL_3_71 = "score_level_3_81";
    private static final String SCORE_LEVEL_3_72 = "score_level_3_82";
    private static final String SCORE_LEVEL_3_73 = "score_level_3_83";
    private static final String SCORE_LEVEL_3_74 = "score_level_3_84";
    private static final String SCORE_LEVEL_3_75 = "score_level_3_85";
    private static final String SCORE_LEVEL_3_76 = "score_level_3_86";
    private static final String SCORE_LEVEL_3_77 = "score_level_3_87";
    private static final String SCORE_LEVEL_3_78 = "score_level_3_88";
    private static final String SCORE_LEVEL_3_79 = "score_level_3_89";
    private static final String SCORE_LEVEL_3_80 = "score_level_3_89";
    private static final String SCORE_LEVEL_3_81 = "score_level_3_81";
    private static final String SCORE_LEVEL_3_82 = "score_level_3_82";
    private static final String SCORE_LEVEL_3_83 = "score_level_3_83";
    private static final String SCORE_LEVEL_3_84 = "score_level_3_84";
    private static final String SCORE_LEVEL_3_85 = "score_level_3_85";
    private static final String SCORE_LEVEL_3_86 = "score_level_3_86";
    private static final String SCORE_LEVEL_3_87 = "score_level_3_87";
    private static final String SCORE_LEVEL_3_88 = "score_level_3_88";
    private static final String SCORE_LEVEL_3_89 = "score_level_3_89";
    private static final String SCORE_LEVEL_3_90 = "score_level_3_90";
    private static final String SCORE_LEVEL_3_91 = "score_level_3_91";
    private static final String SCORE_LEVEL_3_92 = "score_level_3_92";
    private static final String SCORE_LEVEL_3_93 = "score_level_3_93";
    private static final String SCORE_LEVEL_3_94 = "score_level_3_94";
    private static final String SCORE_LEVEL_3_95 = "score_level_3_95";
    private static final String SCORE_LEVEL_3_96 = "score_level_3_96";
    private static final String SCORE_LEVEL_3_97 = "score_level_3_97";
    private static final String SCORE_LEVEL_3_98 = "score_level_3_98";
    private static final String SCORE_LEVEL_3_99 = "score_level_3_99";
    private static final String SCORE_LEVEL_3_100 ="score_level_3_100";
    private static final String SCORE_LEVEL_4_1 =  "score_level_4_1";
    private static final String SCORE_LEVEL_4_2 =  "score_level_4_2";
    private static final String SCORE_LEVEL_4_3 =  "score_level_4_3";
    private static final String SCORE_LEVEL_4_4 =  "score_level_4_4";
    private static final String SCORE_LEVEL_4_5 =  "score_level_4_5";
    private static final String SCORE_LEVEL_4_6 =  "score_level_4_6";
    private static final String SCORE_LEVEL_4_7 =  "score_level_4_7";
    private static final String SCORE_LEVEL_4_8 =  "score_level_4_8";
    private static final String SCORE_LEVEL_4_9 =  "score_level_4_9";
    private static final String SCORE_LEVEL_4_10 = "score_level_4_10";
    private static final String SCORE_LEVEL_4_11 = "score_level_4_11";
    private static final String SCORE_LEVEL_4_12 = "score_level_4_12";
    private static final String SCORE_LEVEL_4_13 = "score_level_4_13";
    private static final String SCORE_LEVEL_4_14 = "score_level_4_14";
    private static final String SCORE_LEVEL_4_15 = "score_level_4_15";
    private static final String SCORE_LEVEL_4_16 = "score_level_4_16";
    private static final String SCORE_LEVEL_4_17 = "score_level_4_17";
    private static final String SCORE_LEVEL_4_18 = "score_level_4_18";
    private static final String SCORE_LEVEL_4_19 = "score_level_4_19";
    private static final String SCORE_LEVEL_4_20 = "score_level_4_20";
    private static final String SCORE_LEVEL_4_21 = "score_level_4_21";
    private static final String SCORE_LEVEL_4_22 = "score_level_4_22";
    private static final String SCORE_LEVEL_4_23 = "score_level_4_23";
    private static final String SCORE_LEVEL_4_24 = "score_level_4_24";
    private static final String SCORE_LEVEL_4_25 = "score_level_4_25";
    private static final String SCORE_LEVEL_4_26 = "score_level_4_26";
    private static final String SCORE_LEVEL_4_27 = "score_level_4_27";
    private static final String SCORE_LEVEL_4_28 = "score_level_4_28";
    private static final String SCORE_LEVEL_4_29 = "score_level_4_29";
    private static final String SCORE_LEVEL_4_30 = "score_level_4_20";
    private static final String SCORE_LEVEL_4_31 = "score_level_4_31";
    private static final String SCORE_LEVEL_4_32 = "score_level_4_32";
    private static final String SCORE_LEVEL_4_33 = "score_level_4_33";
    private static final String SCORE_LEVEL_4_34 = "score_level_4_34";
    private static final String SCORE_LEVEL_4_35 = "score_level_4_35";
    private static final String SCORE_LEVEL_4_36 = "score_level_4_36";
    private static final String SCORE_LEVEL_4_37 = "score_level_4_37";
    private static final String SCORE_LEVEL_4_38 = "score_level_4_38";
    private static final String SCORE_LEVEL_4_39 = "score_level_4_39";
    private static final String SCORE_LEVEL_4_40 = "score_level_4_30";
    private static final String SCORE_LEVEL_4_41 = "score_level_4_41";
    private static final String SCORE_LEVEL_4_42 = "score_level_4_42";
    private static final String SCORE_LEVEL_4_43 = "score_level_4_43";
    private static final String SCORE_LEVEL_4_44 = "score_level_4_44";
    private static final String SCORE_LEVEL_4_45 = "score_level_4_45";
    private static final String SCORE_LEVEL_4_46 = "score_level_4_46";
    private static final String SCORE_LEVEL_4_47 = "score_level_4_47";
    private static final String SCORE_LEVEL_4_48 = "score_level_4_48";
    private static final String SCORE_LEVEL_4_49 = "score_level_4_49";
    private static final String SCORE_LEVEL_4_50 = "score_level_4_50";
    private static final String SCORE_LEVEL_4_51 = "score_level_4_51";
    private static final String SCORE_LEVEL_4_52 = "score_level_4_52";
    private static final String SCORE_LEVEL_4_53 = "score_level_4_53";
    private static final String SCORE_LEVEL_4_54 = "score_level_4_54";
    private static final String SCORE_LEVEL_4_55 = "score_level_4_55";
    private static final String SCORE_LEVEL_4_56 = "score_level_4_56";
    private static final String SCORE_LEVEL_4_57 = "score_level_4_57";
    private static final String SCORE_LEVEL_4_58 = "score_level_4_58";
    private static final String SCORE_LEVEL_4_59 = "score_level_4_59";
    private static final String SCORE_LEVEL_4_60 = "score_level_4_70";
    private static final String SCORE_LEVEL_4_61 = "score_level_4_71";
    private static final String SCORE_LEVEL_4_62 = "score_level_4_72";
    private static final String SCORE_LEVEL_4_63 = "score_level_4_73";
    private static final String SCORE_LEVEL_4_64 = "score_level_4_74";
    private static final String SCORE_LEVEL_4_65 = "score_level_4_75";
    private static final String SCORE_LEVEL_4_66 = "score_level_4_76";
    private static final String SCORE_LEVEL_4_67 = "score_level_4_77";
    private static final String SCORE_LEVEL_4_68 = "score_level_4_78";
    private static final String SCORE_LEVEL_4_69 = "score_level_4_79";
    private static final String SCORE_LEVEL_4_70 = "score_level_4_70";
    private static final String SCORE_LEVEL_4_71 = "score_level_4_81";
    private static final String SCORE_LEVEL_4_72 = "score_level_4_82";
    private static final String SCORE_LEVEL_4_73 = "score_level_4_83";
    private static final String SCORE_LEVEL_4_74 = "score_level_4_84";
    private static final String SCORE_LEVEL_4_75 = "score_level_4_85";
    private static final String SCORE_LEVEL_4_76 = "score_level_4_86";
    private static final String SCORE_LEVEL_4_77 = "score_level_4_87";
    private static final String SCORE_LEVEL_4_78 = "score_level_4_88";
    private static final String SCORE_LEVEL_4_79 = "score_level_4_89";
    private static final String SCORE_LEVEL_4_80 = "score_level_4_89";
    private static final String SCORE_LEVEL_4_81 = "score_level_4_81";
    private static final String SCORE_LEVEL_4_82 = "score_level_4_82";
    private static final String SCORE_LEVEL_4_83 = "score_level_4_83";
    private static final String SCORE_LEVEL_4_84 = "score_level_4_84";
    private static final String SCORE_LEVEL_4_85 = "score_level_4_85";
    private static final String SCORE_LEVEL_4_86 = "score_level_4_86";
    private static final String SCORE_LEVEL_4_87 = "score_level_4_87";
    private static final String SCORE_LEVEL_4_88 = "score_level_4_88";
    private static final String SCORE_LEVEL_4_89 = "score_level_4_89";
    private static final String SCORE_LEVEL_4_90 = "score_level_4_90";
    private static final String SCORE_LEVEL_4_91 = "score_level_4_91";
    private static final String SCORE_LEVEL_4_92 = "score_level_4_92";
    private static final String SCORE_LEVEL_4_93 = "score_level_4_93";
    private static final String SCORE_LEVEL_4_94 = "score_level_4_94";
    private static final String SCORE_LEVEL_4_95 = "score_level_4_95";
    private static final String SCORE_LEVEL_4_96 = "score_level_4_96";
    private static final String SCORE_LEVEL_4_97 = "score_level_4_97";
    private static final String SCORE_LEVEL_4_98 = "score_level_4_98";
    private static final String SCORE_LEVEL_4_99 = "score_level_4_99";
    private static final String SCORE_LEVEL_4_100 ="score_level_4_100";
    private static final String SCORE_LEVEL_5_1 =  "score_level_5_1";
    private static final String SCORE_LEVEL_5_2 =  "score_level_5_2";
    private static final String SCORE_LEVEL_5_3 =  "score_level_5_3";
    private static final String SCORE_LEVEL_5_4 =  "score_level_5_4";
    private static final String SCORE_LEVEL_5_5 =  "score_level_5_5";
    private static final String SCORE_LEVEL_5_6 =  "score_level_5_6";
    private static final String SCORE_LEVEL_5_7 =  "score_level_5_7";
    private static final String SCORE_LEVEL_5_8 =  "score_level_5_8";
    private static final String SCORE_LEVEL_5_9 =  "score_level_5_9";
    private static final String SCORE_LEVEL_5_10 = "score_level_5_10";
    private static final String SCORE_LEVEL_5_11 = "score_level_5_11";
    private static final String SCORE_LEVEL_5_12 = "score_level_5_12";
    private static final String SCORE_LEVEL_5_13 = "score_level_5_13";
    private static final String SCORE_LEVEL_5_14 = "score_level_5_14";
    private static final String SCORE_LEVEL_5_15 = "score_level_5_15";
    private static final String SCORE_LEVEL_5_16 = "score_level_5_16";
    private static final String SCORE_LEVEL_5_17 = "score_level_5_17";
    private static final String SCORE_LEVEL_5_18 = "score_level_5_18";
    private static final String SCORE_LEVEL_5_19 = "score_level_5_19";
    private static final String SCORE_LEVEL_5_20 = "score_level_5_20";
    private static final String SCORE_LEVEL_5_21 = "score_level_5_21";
    private static final String SCORE_LEVEL_5_22 = "score_level_5_22";
    private static final String SCORE_LEVEL_5_23 = "score_level_5_23";
    private static final String SCORE_LEVEL_5_24 = "score_level_5_24";
    private static final String SCORE_LEVEL_5_25 = "score_level_5_25";
    private static final String SCORE_LEVEL_5_26 = "score_level_5_26";
    private static final String SCORE_LEVEL_5_27 = "score_level_5_27";
    private static final String SCORE_LEVEL_5_28 = "score_level_5_28";
    private static final String SCORE_LEVEL_5_29 = "score_level_5_29";
    private static final String SCORE_LEVEL_5_30 = "score_level_5_20";
    private static final String SCORE_LEVEL_5_31 = "score_level_5_31";
    private static final String SCORE_LEVEL_5_32 = "score_level_5_32";
    private static final String SCORE_LEVEL_5_33 = "score_level_5_33";
    private static final String SCORE_LEVEL_5_34 = "score_level_5_34";
    private static final String SCORE_LEVEL_5_35 = "score_level_5_35";
    private static final String SCORE_LEVEL_5_36 = "score_level_5_36";
    private static final String SCORE_LEVEL_5_37 = "score_level_5_37";
    private static final String SCORE_LEVEL_5_38 = "score_level_5_38";
    private static final String SCORE_LEVEL_5_39 = "score_level_5_39";
    private static final String SCORE_LEVEL_5_40 = "score_level_5_30";
    private static final String SCORE_LEVEL_5_41 = "score_level_5_41";
    private static final String SCORE_LEVEL_5_42 = "score_level_5_42";
    private static final String SCORE_LEVEL_5_43 = "score_level_5_43";
    private static final String SCORE_LEVEL_5_44 = "score_level_5_44";
    private static final String SCORE_LEVEL_5_45 = "score_level_5_45";
    private static final String SCORE_LEVEL_5_46 = "score_level_5_46";
    private static final String SCORE_LEVEL_5_47 = "score_level_5_47";
    private static final String SCORE_LEVEL_5_48 = "score_level_5_48";
    private static final String SCORE_LEVEL_5_49 = "score_level_5_49";
    private static final String SCORE_LEVEL_5_50 = "score_level_5_50";
    private static final String SCORE_LEVEL_5_51 = "score_level_5_51";
    private static final String SCORE_LEVEL_5_52 = "score_level_5_52";
    private static final String SCORE_LEVEL_5_53 = "score_level_5_53";
    private static final String SCORE_LEVEL_5_54 = "score_level_5_54";
    private static final String SCORE_LEVEL_5_55 = "score_level_5_55";
    private static final String SCORE_LEVEL_5_56 = "score_level_5_56";
    private static final String SCORE_LEVEL_5_57 = "score_level_5_57";
    private static final String SCORE_LEVEL_5_58 = "score_level_5_58";
    private static final String SCORE_LEVEL_5_59 = "score_level_5_59";
    private static final String SCORE_LEVEL_5_60 = "score_level_5_70";
    private static final String SCORE_LEVEL_5_61 = "score_level_5_71";
    private static final String SCORE_LEVEL_5_62 = "score_level_5_72";
    private static final String SCORE_LEVEL_5_63 = "score_level_5_73";
    private static final String SCORE_LEVEL_5_64 = "score_level_5_74";
    private static final String SCORE_LEVEL_5_65 = "score_level_5_75";
    private static final String SCORE_LEVEL_5_66 = "score_level_5_76";
    private static final String SCORE_LEVEL_5_67 = "score_level_5_77";
    private static final String SCORE_LEVEL_5_68 = "score_level_5_78";
    private static final String SCORE_LEVEL_5_69 = "score_level_5_79";
    private static final String SCORE_LEVEL_5_70 = "score_level_5_70";
    private static final String SCORE_LEVEL_5_71 = "score_level_5_81";
    private static final String SCORE_LEVEL_5_72 = "score_level_5_82";
    private static final String SCORE_LEVEL_5_73 = "score_level_5_83";
    private static final String SCORE_LEVEL_5_74 = "score_level_5_84";
    private static final String SCORE_LEVEL_5_75 = "score_level_5_85";
    private static final String SCORE_LEVEL_5_76 = "score_level_5_86";
    private static final String SCORE_LEVEL_5_77 = "score_level_5_87";
    private static final String SCORE_LEVEL_5_78 = "score_level_5_88";
    private static final String SCORE_LEVEL_5_79 = "score_level_5_89";
    private static final String SCORE_LEVEL_5_80 = "score_level_5_89";
    private static final String SCORE_LEVEL_5_81 = "score_level_5_81";
    private static final String SCORE_LEVEL_5_82 = "score_level_5_82";
    private static final String SCORE_LEVEL_5_83 = "score_level_5_83";
    private static final String SCORE_LEVEL_5_84 = "score_level_5_84";
    private static final String SCORE_LEVEL_5_85 = "score_level_5_85";
    private static final String SCORE_LEVEL_5_86 = "score_level_5_86";
    private static final String SCORE_LEVEL_5_87 = "score_level_5_87";
    private static final String SCORE_LEVEL_5_88 = "score_level_5_88";
    private static final String SCORE_LEVEL_5_89 = "score_level_5_89";
    private static final String SCORE_LEVEL_5_90 = "score_level_5_90";
    private static final String SCORE_LEVEL_5_91 = "score_level_5_91";
    private static final String SCORE_LEVEL_5_92 = "score_level_5_92";
    private static final String SCORE_LEVEL_5_93 = "score_level_5_93";
    private static final String SCORE_LEVEL_5_94 = "score_level_5_94";
    private static final String SCORE_LEVEL_5_95 = "score_level_5_95";
    private static final String SCORE_LEVEL_5_96 = "score_level_5_96";
    private static final String SCORE_LEVEL_5_97 = "score_level_5_97";
    private static final String SCORE_LEVEL_5_98 = "score_level_5_98";
    private static final String SCORE_LEVEL_5_99 = "score_level_5_99";
    private static final String SCORE_LEVEL_5_100 ="score_level_5_100";
    private static final String SCORE_LEVEL_6_1 =  "score_level_6_1";
    private static final String SCORE_LEVEL_6_2 =  "score_level_6_2";
    private static final String SCORE_LEVEL_6_3 =  "score_level_6_3";
    private static final String SCORE_LEVEL_6_4 =  "score_level_6_4";
    private static final String SCORE_LEVEL_6_5 =  "score_level_6_5";
    private static final String SCORE_LEVEL_6_6 =  "score_level_6_6";
    private static final String SCORE_LEVEL_6_7 =  "score_level_6_7";
    private static final String SCORE_LEVEL_6_8 =  "score_level_6_8";
    private static final String SCORE_LEVEL_6_9 =  "score_level_6_9";
    private static final String SCORE_LEVEL_6_10 = "score_level_6_10";
    private static final String SCORE_LEVEL_6_11 = "score_level_6_11";
    private static final String SCORE_LEVEL_6_12 = "score_level_6_12";
    private static final String SCORE_LEVEL_6_13 = "score_level_6_13";
    private static final String SCORE_LEVEL_6_14 = "score_level_6_14";
    private static final String SCORE_LEVEL_6_15 = "score_level_6_15";
    private static final String SCORE_LEVEL_6_16 = "score_level_6_16";
    private static final String SCORE_LEVEL_6_17 = "score_level_6_17";
    private static final String SCORE_LEVEL_6_18 = "score_level_6_18";
    private static final String SCORE_LEVEL_6_19 = "score_level_6_19";
    private static final String SCORE_LEVEL_6_20 = "score_level_6_20";
    private static final String SCORE_LEVEL_6_21 = "score_level_6_21";
    private static final String SCORE_LEVEL_6_22 = "score_level_6_22";
    private static final String SCORE_LEVEL_6_23 = "score_level_6_23";
    private static final String SCORE_LEVEL_6_24 = "score_level_6_24";
    private static final String SCORE_LEVEL_6_25 = "score_level_6_25";
    private static final String SCORE_LEVEL_6_26 = "score_level_6_26";
    private static final String SCORE_LEVEL_6_27 = "score_level_6_27";
    private static final String SCORE_LEVEL_6_28 = "score_level_6_28";
    private static final String SCORE_LEVEL_6_29 = "score_level_6_29";
    private static final String SCORE_LEVEL_6_30 = "score_level_6_20";
    private static final String SCORE_LEVEL_6_31 = "score_level_6_31";
    private static final String SCORE_LEVEL_6_32 = "score_level_6_32";
    private static final String SCORE_LEVEL_6_33 = "score_level_6_33";
    private static final String SCORE_LEVEL_6_34 = "score_level_6_34";
    private static final String SCORE_LEVEL_6_35 = "score_level_6_35";
    private static final String SCORE_LEVEL_6_36 = "score_level_6_36";
    private static final String SCORE_LEVEL_6_37 = "score_level_6_37";
    private static final String SCORE_LEVEL_6_38 = "score_level_6_38";
    private static final String SCORE_LEVEL_6_39 = "score_level_6_39";
    private static final String SCORE_LEVEL_6_40 = "score_level_6_30";
    private static final String SCORE_LEVEL_6_41 = "score_level_6_41";
    private static final String SCORE_LEVEL_6_42 = "score_level_6_42";
    private static final String SCORE_LEVEL_6_43 = "score_level_6_43";
    private static final String SCORE_LEVEL_6_44 = "score_level_6_44";
    private static final String SCORE_LEVEL_6_45 = "score_level_6_45";
    private static final String SCORE_LEVEL_6_46 = "score_level_6_46";
    private static final String SCORE_LEVEL_6_47 = "score_level_6_47";
    private static final String SCORE_LEVEL_6_48 = "score_level_6_48";
    private static final String SCORE_LEVEL_6_49 = "score_level_6_49";
    private static final String SCORE_LEVEL_6_50 = "score_level_6_50";
    private static final String SCORE_LEVEL_6_51 = "score_level_6_51";
    private static final String SCORE_LEVEL_6_52 = "score_level_6_52";
    private static final String SCORE_LEVEL_6_53 = "score_level_6_53";
    private static final String SCORE_LEVEL_6_54 = "score_level_6_54";
    private static final String SCORE_LEVEL_6_55 = "score_level_6_55";
    private static final String SCORE_LEVEL_6_56 = "score_level_6_56";
    private static final String SCORE_LEVEL_6_57 = "score_level_6_57";
    private static final String SCORE_LEVEL_6_58 = "score_level_6_58";
    private static final String SCORE_LEVEL_6_59 = "score_level_6_59";
    private static final String SCORE_LEVEL_6_60 = "score_level_6_70";
    private static final String SCORE_LEVEL_6_61 = "score_level_6_71";
    private static final String SCORE_LEVEL_6_62 = "score_level_6_72";
    private static final String SCORE_LEVEL_6_63 = "score_level_6_73";
    private static final String SCORE_LEVEL_6_64 = "score_level_6_74";
    private static final String SCORE_LEVEL_6_65 = "score_level_6_75";
    private static final String SCORE_LEVEL_6_66 = "score_level_6_76";
    private static final String SCORE_LEVEL_6_67 = "score_level_6_77";
    private static final String SCORE_LEVEL_6_68 = "score_level_6_78";
    private static final String SCORE_LEVEL_6_69 = "score_level_6_79";
    private static final String SCORE_LEVEL_6_70 = "score_level_6_70";
    private static final String SCORE_LEVEL_6_71 = "score_level_6_71";
    private static final String SCORE_LEVEL_6_72 = "score_level_6_72";
    private static final String SCORE_LEVEL_6_73 = "score_level_6_73";
    private static final String SCORE_LEVEL_6_74 = "score_level_6_74";
    private static final String SCORE_LEVEL_6_75 = "score_level_6_75";
    private static final String SCORE_LEVEL_6_76 = "score_level_6_76";
    private static final String SCORE_LEVEL_6_77 = "score_level_6_77";
    private static final String SCORE_LEVEL_6_78 = "score_level_6_78";
    private static final String SCORE_LEVEL_6_79 = "score_level_6_79";
    private static final String SCORE_LEVEL_6_80 = "score_level_6_70";
    private static final String SCORE_LEVEL_6_81 = "score_level_6_81";
    private static final String SCORE_LEVEL_6_82 = "score_level_6_82";
    private static final String SCORE_LEVEL_6_83 = "score_level_6_83";
    private static final String SCORE_LEVEL_6_84 = "score_level_6_84";
    private static final String SCORE_LEVEL_6_85 = "score_level_6_85";
    private static final String SCORE_LEVEL_6_86 = "score_level_6_86";
    private static final String SCORE_LEVEL_6_87 = "score_level_6_87";
    private static final String SCORE_LEVEL_6_88 = "score_level_6_88";
    private static final String SCORE_LEVEL_6_89 = "score_level_6_89";
    private static final String SCORE_LEVEL_6_90 = "score_level_6_90";
    private static final String SCORE_LEVEL_6_91 = "score_level_6_91";
    private static final String SCORE_LEVEL_6_92 = "score_level_6_92";
    private static final String SCORE_LEVEL_6_93 = "score_level_6_93";
    private static final String SCORE_LEVEL_6_94 = "score_level_6_94";
    private static final String SCORE_LEVEL_6_95 = "score_level_6_95";
    private static final String SCORE_LEVEL_6_96 = "score_level_6_96";
    private static final String SCORE_LEVEL_6_97 = "score_level_6_97";
    private static final String SCORE_LEVEL_6_98 = "score_level_6_98";
    private static final String SCORE_LEVEL_6_99 = "score_level_6_99";
    private static final String SCORE_LEVEL_6_100 ="score_level_6_100";
    private static final String POINTS_LEVEL_1_1 = "points_level_1_1";
    private static final String POINTS_LEVEL_1_2 = "points_level_1_2";
    private static final String POINTS_LEVEL_1_3 = "points_level_1_3";
    private static final String POINTS_LEVEL_1_4 = "points_level_1_4";
    private static final String POINTS_LEVEL_1_5 = "points_level_1_5";
    private static final String POINTS_LEVEL_1_6 = "points_level_1_6";
    private static final String POINTS_LEVEL_1_7 = "points_level_1_7";
    private static final String POINTS_LEVEL_1_8 = "points_level_1_8";
    private static final String POINTS_LEVEL_1_9 = "points_level_1_9";
    private static final String POINTS_LEVEL_1_10 = "points_level_1_10";
    private static final String POINTS_LEVEL_1_11 = "points_level_1_11";
    private static final String POINTS_LEVEL_1_12 = "points_level_1_12";
    private static final String POINTS_LEVEL_1_13 = "points_level_1_13";
    private static final String POINTS_LEVEL_1_14 = "points_level_1_14";
    private static final String POINTS_LEVEL_1_15 = "points_level_1_15";
    private static final String POINTS_LEVEL_1_16 = "points_level_1_16";
    private static final String POINTS_LEVEL_1_17 = "points_level_1_17";
    private static final String POINTS_LEVEL_1_18 = "points_level_1_18";
    private static final String POINTS_LEVEL_1_19 = "points_level_1_19";
    private static final String POINTS_LEVEL_1_20 = "points_level_1_20";
    private static final String POINTS_LEVEL_1_21 = "points_level_1_21";
    private static final String POINTS_LEVEL_1_22 = "points_level_1_22";
    private static final String POINTS_LEVEL_1_23 = "points_level_1_23";
    private static final String POINTS_LEVEL_1_24 = "points_level_1_24";
    private static final String POINTS_LEVEL_1_25 = "points_level_1_25";
    private static final String POINTS_LEVEL_1_26 = "points_level_1_26";
    private static final String POINTS_LEVEL_1_27 = "points_level_1_27";
    private static final String POINTS_LEVEL_1_28 = "points_level_1_28";
    private static final String POINTS_LEVEL_1_29 = "points_level_1_29";
    private static final String POINTS_LEVEL_1_30 = "points_level_1_20";
    private static final String POINTS_LEVEL_1_31 = "points_level_1_31";
    private static final String POINTS_LEVEL_1_32 = "points_level_1_32";
    private static final String POINTS_LEVEL_1_33 = "points_level_1_33";
    private static final String POINTS_LEVEL_1_34 = "points_level_1_34";
    private static final String POINTS_LEVEL_1_35 = "points_level_1_35";
    private static final String POINTS_LEVEL_1_36 = "points_level_1_36";
    private static final String POINTS_LEVEL_1_37 = "points_level_1_37";
    private static final String POINTS_LEVEL_1_38 = "points_level_1_38";
    private static final String POINTS_LEVEL_1_39 = "points_level_1_39";
    private static final String POINTS_LEVEL_1_40 = "points_level_1_30";
    private static final String POINTS_LEVEL_1_41 = "points_level_1_41";
    private static final String POINTS_LEVEL_1_42 = "points_level_1_42";
    private static final String POINTS_LEVEL_1_43 = "points_level_1_43";
    private static final String POINTS_LEVEL_1_44 = "points_level_1_44";
    private static final String POINTS_LEVEL_1_45 = "points_level_1_45";
    private static final String POINTS_LEVEL_1_46 = "points_level_1_46";
    private static final String POINTS_LEVEL_1_47 = "points_level_1_47";
    private static final String POINTS_LEVEL_1_48 = "points_level_1_48";
    private static final String POINTS_LEVEL_1_49 = "points_level_1_49";
    private static final String POINTS_LEVEL_1_50 = "points_level_1_50";
    private static final String POINTS_LEVEL_1_51 = "points_level_1_51";
    private static final String POINTS_LEVEL_1_52 = "points_level_1_52";
    private static final String POINTS_LEVEL_1_53 = "points_level_1_53";
    private static final String POINTS_LEVEL_1_54 = "points_level_1_54";
    private static final String POINTS_LEVEL_1_55 = "points_level_1_55";
    private static final String POINTS_LEVEL_1_56 = "points_level_1_56";
    private static final String POINTS_LEVEL_1_57 = "points_level_1_57";
    private static final String POINTS_LEVEL_1_58 = "points_level_1_58";
    private static final String POINTS_LEVEL_1_59 = "points_level_1_59";
    private static final String POINTS_LEVEL_1_60 = "points_level_1_70";
    private static final String POINTS_LEVEL_1_61 = "points_level_1_71";
    private static final String POINTS_LEVEL_1_62 = "points_level_1_72";
    private static final String POINTS_LEVEL_1_63 = "points_level_1_73";
    private static final String POINTS_LEVEL_1_64 = "points_level_1_74";
    private static final String POINTS_LEVEL_1_65 = "points_level_1_75";
    private static final String POINTS_LEVEL_1_66 = "points_level_1_76";
    private static final String POINTS_LEVEL_1_67 = "points_level_1_77";
    private static final String POINTS_LEVEL_1_68 = "points_level_1_78";
    private static final String POINTS_LEVEL_1_69 = "points_level_1_79";
    private static final String POINTS_LEVEL_1_70 = "points_level_1_70";
    private static final String POINTS_LEVEL_1_71 = "points_level_1_81";
    private static final String POINTS_LEVEL_1_72 = "points_level_1_82";
    private static final String POINTS_LEVEL_1_73 = "points_level_1_83";
    private static final String POINTS_LEVEL_1_74 = "points_level_1_84";
    private static final String POINTS_LEVEL_1_75 = "points_level_1_85";
    private static final String POINTS_LEVEL_1_76 = "points_level_1_86";
    private static final String POINTS_LEVEL_1_77 = "points_level_1_87";
    private static final String POINTS_LEVEL_1_78 = "points_level_1_88";
    private static final String POINTS_LEVEL_1_79 = "points_level_1_89";
    private static final String POINTS_LEVEL_1_80 = "points_level_1_89";
    private static final String POINTS_LEVEL_1_81 = "points_level_1_81";
    private static final String POINTS_LEVEL_1_82 = "points_level_1_82";
    private static final String POINTS_LEVEL_1_83 = "points_level_1_83";
    private static final String POINTS_LEVEL_1_84 = "points_level_1_84";
    private static final String POINTS_LEVEL_1_85 = "points_level_1_85";
    private static final String POINTS_LEVEL_1_86 = "points_level_1_86";
    private static final String POINTS_LEVEL_1_87 = "points_level_1_87";
    private static final String POINTS_LEVEL_1_88 = "points_level_1_88";
    private static final String POINTS_LEVEL_1_89 = "points_level_1_89";
    private static final String POINTS_LEVEL_1_90 = "points_level_1_90";
    private static final String POINTS_LEVEL_1_91 = "points_level_1_91";
    private static final String POINTS_LEVEL_1_92 = "points_level_1_92";
    private static final String POINTS_LEVEL_1_93 = "points_level_1_93";
    private static final String POINTS_LEVEL_1_94 = "points_level_1_94";
    private static final String POINTS_LEVEL_1_95 = "points_level_1_95";
    private static final String POINTS_LEVEL_1_96 = "points_level_1_96";
    private static final String POINTS_LEVEL_1_97 = "points_level_1_97";
    private static final String POINTS_LEVEL_1_98 = "points_level_1_98";
    private static final String POINTS_LEVEL_1_99 = "points_level_1_99";
    private static final String POINTS_LEVEL_1_100 ="points_level_1_100";
    private static final String POINTS_LEVEL_2_1 =  "points_level_2_1";
    private static final String POINTS_LEVEL_2_2 =  "points_level_2_2";
    private static final String POINTS_LEVEL_2_3 =  "points_level_2_3";
    private static final String POINTS_LEVEL_2_4 =  "points_level_2_4";
    private static final String POINTS_LEVEL_2_5 =  "points_level_2_5";
    private static final String POINTS_LEVEL_2_6 =  "points_level_2_6";
    private static final String POINTS_LEVEL_2_7 =  "points_level_2_7";
    private static final String POINTS_LEVEL_2_8 =  "points_level_2_8";
    private static final String POINTS_LEVEL_2_9 =  "points_level_2_9";
    private static final String POINTS_LEVEL_2_10 = "points_level_2_10";
    private static final String POINTS_LEVEL_2_11 = "points_level_2_11";
    private static final String POINTS_LEVEL_2_12 = "points_level_2_12";
    private static final String POINTS_LEVEL_2_13 = "points_level_2_13";
    private static final String POINTS_LEVEL_2_14 = "points_level_2_14";
    private static final String POINTS_LEVEL_2_15 = "points_level_2_15";
    private static final String POINTS_LEVEL_2_16 = "points_level_2_16";
    private static final String POINTS_LEVEL_2_17 = "points_level_2_17";
    private static final String POINTS_LEVEL_2_18 = "points_level_2_18";
    private static final String POINTS_LEVEL_2_19 = "points_level_2_19";
    private static final String POINTS_LEVEL_2_20 = "points_level_2_20";
    private static final String POINTS_LEVEL_2_21 = "points_level_2_21";
    private static final String POINTS_LEVEL_2_22 = "points_level_2_22";
    private static final String POINTS_LEVEL_2_23 = "points_level_2_23";
    private static final String POINTS_LEVEL_2_24 = "points_level_2_24";
    private static final String POINTS_LEVEL_2_25 = "points_level_2_25";
    private static final String POINTS_LEVEL_2_26 = "points_level_2_26";
    private static final String POINTS_LEVEL_2_27 = "points_level_2_27";
    private static final String POINTS_LEVEL_2_28 = "points_level_2_28";
    private static final String POINTS_LEVEL_2_29 = "points_level_2_29";
    private static final String POINTS_LEVEL_2_30 = "points_level_2_20";
    private static final String POINTS_LEVEL_2_31 = "points_level_2_31";
    private static final String POINTS_LEVEL_2_32 = "points_level_2_32";
    private static final String POINTS_LEVEL_2_33 = "points_level_2_33";
    private static final String POINTS_LEVEL_2_34 = "points_level_2_34";
    private static final String POINTS_LEVEL_2_35 = "points_level_2_35";
    private static final String POINTS_LEVEL_2_36 = "points_level_2_36";
    private static final String POINTS_LEVEL_2_37 = "points_level_2_37";
    private static final String POINTS_LEVEL_2_38 = "points_level_2_38";
    private static final String POINTS_LEVEL_2_39 = "points_level_2_39";
    private static final String POINTS_LEVEL_2_40 = "points_level_2_30";
    private static final String POINTS_LEVEL_2_41 = "points_level_2_41";
    private static final String POINTS_LEVEL_2_42 = "points_level_2_42";
    private static final String POINTS_LEVEL_2_43 = "points_level_2_43";
    private static final String POINTS_LEVEL_2_44 = "points_level_2_44";
    private static final String POINTS_LEVEL_2_45 = "points_level_2_45";
    private static final String POINTS_LEVEL_2_46 = "points_level_2_46";
    private static final String POINTS_LEVEL_2_47 = "points_level_2_47";
    private static final String POINTS_LEVEL_2_48 = "points_level_2_48";
    private static final String POINTS_LEVEL_2_49 = "points_level_2_49";
    private static final String POINTS_LEVEL_2_50 = "points_level_2_50";
    private static final String POINTS_LEVEL_2_51 = "points_level_2_51";
    private static final String POINTS_LEVEL_2_52 = "points_level_2_52";
    private static final String POINTS_LEVEL_2_53 = "points_level_2_53";
    private static final String POINTS_LEVEL_2_54 = "points_level_2_54";
    private static final String POINTS_LEVEL_2_55 = "points_level_2_55";
    private static final String POINTS_LEVEL_2_56 = "points_level_2_56";
    private static final String POINTS_LEVEL_2_57 = "points_level_2_57";
    private static final String POINTS_LEVEL_2_58 = "points_level_2_58";
    private static final String POINTS_LEVEL_2_59 = "points_level_2_59";
    private static final String POINTS_LEVEL_2_60 = "points_level_2_70";
    private static final String POINTS_LEVEL_2_61 = "points_level_2_71";
    private static final String POINTS_LEVEL_2_62 = "points_level_2_72";
    private static final String POINTS_LEVEL_2_63 = "points_level_2_73";
    private static final String POINTS_LEVEL_2_64 = "points_level_2_74";
    private static final String POINTS_LEVEL_2_65 = "points_level_2_75";
    private static final String POINTS_LEVEL_2_66 = "points_level_2_76";
    private static final String POINTS_LEVEL_2_67 = "points_level_2_77";
    private static final String POINTS_LEVEL_2_68 = "points_level_2_78";
    private static final String POINTS_LEVEL_2_69 = "points_level_2_79";
    private static final String POINTS_LEVEL_2_70 = "points_level_2_70";
    private static final String POINTS_LEVEL_2_71 = "points_level_2_81";
    private static final String POINTS_LEVEL_2_72 = "points_level_2_82";
    private static final String POINTS_LEVEL_2_73 = "points_level_2_83";
    private static final String POINTS_LEVEL_2_74 = "points_level_2_84";
    private static final String POINTS_LEVEL_2_75 = "points_level_2_85";
    private static final String POINTS_LEVEL_2_76 = "points_level_2_86";
    private static final String POINTS_LEVEL_2_77 = "points_level_2_87";
    private static final String POINTS_LEVEL_2_78 = "points_level_2_88";
    private static final String POINTS_LEVEL_2_79 = "points_level_2_89";
    private static final String POINTS_LEVEL_2_80 = "points_level_2_89";
    private static final String POINTS_LEVEL_2_81 = "points_level_2_81";
    private static final String POINTS_LEVEL_2_82 = "points_level_2_82";
    private static final String POINTS_LEVEL_2_83 = "points_level_2_83";
    private static final String POINTS_LEVEL_2_84 = "points_level_2_84";
    private static final String POINTS_LEVEL_2_85 = "points_level_2_85";
    private static final String POINTS_LEVEL_2_86 = "points_level_2_86";
    private static final String POINTS_LEVEL_2_87 = "points_level_2_87";
    private static final String POINTS_LEVEL_2_88 = "points_level_2_88";
    private static final String POINTS_LEVEL_2_89 = "points_level_2_89";
    private static final String POINTS_LEVEL_2_90 = "points_level_2_90";
    private static final String POINTS_LEVEL_2_91 = "points_level_2_91";
    private static final String POINTS_LEVEL_2_92 = "points_level_2_92";
    private static final String POINTS_LEVEL_2_93 = "points_level_2_93";
    private static final String POINTS_LEVEL_2_94 = "points_level_2_94";
    private static final String POINTS_LEVEL_2_95 = "points_level_2_95";
    private static final String POINTS_LEVEL_2_96 = "points_level_2_96";
    private static final String POINTS_LEVEL_2_97 = "points_level_2_97";
    private static final String POINTS_LEVEL_2_98 = "points_level_2_98";
    private static final String POINTS_LEVEL_2_99 = "points_level_2_99";
    private static final String POINTS_LEVEL_2_100 ="points_level_2_100";
    private static final String POINTS_LEVEL_3_1 =  "points_level_3_1";
    private static final String POINTS_LEVEL_3_2 =  "points_level_3_2";
    private static final String POINTS_LEVEL_3_3 =  "points_level_3_3";
    private static final String POINTS_LEVEL_3_4 =  "points_level_3_4";
    private static final String POINTS_LEVEL_3_5 =  "points_level_3_5";
    private static final String POINTS_LEVEL_3_6 =  "points_level_3_6";
    private static final String POINTS_LEVEL_3_7 =  "points_level_3_7";
    private static final String POINTS_LEVEL_3_8 =  "points_level_3_8";
    private static final String POINTS_LEVEL_3_9 =  "points_level_3_9";
    private static final String POINTS_LEVEL_3_10 = "points_level_3_10";
    private static final String POINTS_LEVEL_3_11 = "points_level_3_11";
    private static final String POINTS_LEVEL_3_12 = "points_level_3_12";
    private static final String POINTS_LEVEL_3_13 = "points_level_3_13";
    private static final String POINTS_LEVEL_3_14 = "points_level_3_14";
    private static final String POINTS_LEVEL_3_15 = "points_level_3_15";
    private static final String POINTS_LEVEL_3_16 = "points_level_3_16";
    private static final String POINTS_LEVEL_3_17 = "points_level_3_17";
    private static final String POINTS_LEVEL_3_18 = "points_level_3_18";
    private static final String POINTS_LEVEL_3_19 = "points_level_3_19";
    private static final String POINTS_LEVEL_3_20 = "points_level_3_20";
    private static final String POINTS_LEVEL_3_21 = "points_level_3_21";
    private static final String POINTS_LEVEL_3_22 = "points_level_3_22";
    private static final String POINTS_LEVEL_3_23 = "points_level_3_23";
    private static final String POINTS_LEVEL_3_24 = "points_level_3_24";
    private static final String POINTS_LEVEL_3_25 = "points_level_3_25";
    private static final String POINTS_LEVEL_3_26 = "points_level_3_26";
    private static final String POINTS_LEVEL_3_27 = "points_level_3_27";
    private static final String POINTS_LEVEL_3_28 = "points_level_3_28";
    private static final String POINTS_LEVEL_3_29 = "points_level_3_29";
    private static final String POINTS_LEVEL_3_30 = "points_level_3_20";
    private static final String POINTS_LEVEL_3_31 = "points_level_3_31";
    private static final String POINTS_LEVEL_3_32 = "points_level_3_32";
    private static final String POINTS_LEVEL_3_33 = "points_level_3_33";
    private static final String POINTS_LEVEL_3_34 = "points_level_3_34";
    private static final String POINTS_LEVEL_3_35 = "points_level_3_35";
    private static final String POINTS_LEVEL_3_36 = "points_level_3_36";
    private static final String POINTS_LEVEL_3_37 = "points_level_3_37";
    private static final String POINTS_LEVEL_3_38 = "points_level_3_38";
    private static final String POINTS_LEVEL_3_39 = "points_level_3_39";
    private static final String POINTS_LEVEL_3_40 = "points_level_3_30";
    private static final String POINTS_LEVEL_3_41 = "points_level_3_41";
    private static final String POINTS_LEVEL_3_42 = "points_level_3_42";
    private static final String POINTS_LEVEL_3_43 = "points_level_3_43";
    private static final String POINTS_LEVEL_3_44 = "points_level_3_44";
    private static final String POINTS_LEVEL_3_45 = "points_level_3_45";
    private static final String POINTS_LEVEL_3_46 = "points_level_3_46";
    private static final String POINTS_LEVEL_3_47 = "points_level_3_47";
    private static final String POINTS_LEVEL_3_48 = "points_level_3_48";
    private static final String POINTS_LEVEL_3_49 = "points_level_3_49";
    private static final String POINTS_LEVEL_3_50 = "points_level_3_50";
    private static final String POINTS_LEVEL_3_51 = "points_level_3_51";
    private static final String POINTS_LEVEL_3_52 = "points_level_3_52";
    private static final String POINTS_LEVEL_3_53 = "points_level_3_53";
    private static final String POINTS_LEVEL_3_54 = "points_level_3_54";
    private static final String POINTS_LEVEL_3_55 = "points_level_3_55";
    private static final String POINTS_LEVEL_3_56 = "points_level_3_56";
    private static final String POINTS_LEVEL_3_57 = "points_level_3_57";
    private static final String POINTS_LEVEL_3_58 = "points_level_3_58";
    private static final String POINTS_LEVEL_3_59 = "points_level_3_59";
    private static final String POINTS_LEVEL_3_60 = "points_level_3_70";
    private static final String POINTS_LEVEL_3_61 = "points_level_3_71";
    private static final String POINTS_LEVEL_3_62 = "points_level_3_72";
    private static final String POINTS_LEVEL_3_63 = "points_level_3_73";
    private static final String POINTS_LEVEL_3_64 = "points_level_3_74";
    private static final String POINTS_LEVEL_3_65 = "points_level_3_75";
    private static final String POINTS_LEVEL_3_66 = "points_level_3_76";
    private static final String POINTS_LEVEL_3_67 = "points_level_3_77";
    private static final String POINTS_LEVEL_3_68 = "points_level_3_78";
    private static final String POINTS_LEVEL_3_69 = "points_level_3_79";
    private static final String POINTS_LEVEL_3_70 = "points_level_3_70";
    private static final String POINTS_LEVEL_3_71 = "points_level_3_81";
    private static final String POINTS_LEVEL_3_72 = "points_level_3_82";
    private static final String POINTS_LEVEL_3_73 = "points_level_3_83";
    private static final String POINTS_LEVEL_3_74 = "points_level_3_84";
    private static final String POINTS_LEVEL_3_75 = "points_level_3_85";
    private static final String POINTS_LEVEL_3_76 = "points_level_3_86";
    private static final String POINTS_LEVEL_3_77 = "points_level_3_87";
    private static final String POINTS_LEVEL_3_78 = "points_level_3_88";
    private static final String POINTS_LEVEL_3_79 = "points_level_3_89";
    private static final String POINTS_LEVEL_3_80 = "points_level_3_89";
    private static final String POINTS_LEVEL_3_81 = "points_level_3_81";
    private static final String POINTS_LEVEL_3_82 = "points_level_3_82";
    private static final String POINTS_LEVEL_3_83 = "points_level_3_83";
    private static final String POINTS_LEVEL_3_84 = "points_level_3_84";
    private static final String POINTS_LEVEL_3_85 = "points_level_3_85";
    private static final String POINTS_LEVEL_3_86 = "points_level_3_86";
    private static final String POINTS_LEVEL_3_87 = "points_level_3_87";
    private static final String POINTS_LEVEL_3_88 = "points_level_3_88";
    private static final String POINTS_LEVEL_3_89 = "points_level_3_89";
    private static final String POINTS_LEVEL_3_90 = "points_level_3_90";
    private static final String POINTS_LEVEL_3_91 = "points_level_3_91";
    private static final String POINTS_LEVEL_3_92 = "points_level_3_92";
    private static final String POINTS_LEVEL_3_93 = "points_level_3_93";
    private static final String POINTS_LEVEL_3_94 = "points_level_3_94";
    private static final String POINTS_LEVEL_3_95 = "points_level_3_95";
    private static final String POINTS_LEVEL_3_96 = "points_level_3_96";
    private static final String POINTS_LEVEL_3_97 = "points_level_3_97";
    private static final String POINTS_LEVEL_3_98 = "points_level_3_98";
    private static final String POINTS_LEVEL_3_99 = "points_level_3_99";
    private static final String POINTS_LEVEL_3_100 ="points_level_3_100";
    private static final String POINTS_LEVEL_4_1 =  "points_level_4_1";
    private static final String POINTS_LEVEL_4_2 =  "points_level_4_2";
    private static final String POINTS_LEVEL_4_3 =  "points_level_4_3";
    private static final String POINTS_LEVEL_4_4 =  "points_level_4_4";
    private static final String POINTS_LEVEL_4_5 =  "points_level_4_5";
    private static final String POINTS_LEVEL_4_6 =  "points_level_4_6";
    private static final String POINTS_LEVEL_4_7 =  "points_level_4_7";
    private static final String POINTS_LEVEL_4_8 =  "points_level_4_8";
    private static final String POINTS_LEVEL_4_9 =  "points_level_4_9";
    private static final String POINTS_LEVEL_4_10 = "points_level_4_10";
    private static final String POINTS_LEVEL_4_11 = "points_level_4_11";
    private static final String POINTS_LEVEL_4_12 = "points_level_4_12";
    private static final String POINTS_LEVEL_4_13 = "points_level_4_13";
    private static final String POINTS_LEVEL_4_14 = "points_level_4_14";
    private static final String POINTS_LEVEL_4_15 = "points_level_4_15";
    private static final String POINTS_LEVEL_4_16 = "points_level_4_16";
    private static final String POINTS_LEVEL_4_17 = "points_level_4_17";
    private static final String POINTS_LEVEL_4_18 = "points_level_4_18";
    private static final String POINTS_LEVEL_4_19 = "points_level_4_19";
    private static final String POINTS_LEVEL_4_20 = "points_level_4_20";
    private static final String POINTS_LEVEL_4_21 = "points_level_4_21";
    private static final String POINTS_LEVEL_4_22 = "points_level_4_22";
    private static final String POINTS_LEVEL_4_23 = "points_level_4_23";
    private static final String POINTS_LEVEL_4_24 = "points_level_4_24";
    private static final String POINTS_LEVEL_4_25 = "points_level_4_25";
    private static final String POINTS_LEVEL_4_26 = "points_level_4_26";
    private static final String POINTS_LEVEL_4_27 = "points_level_4_27";
    private static final String POINTS_LEVEL_4_28 = "points_level_4_28";
    private static final String POINTS_LEVEL_4_29 = "points_level_4_29";
    private static final String POINTS_LEVEL_4_30 = "points_level_4_20";
    private static final String POINTS_LEVEL_4_31 = "points_level_4_31";
    private static final String POINTS_LEVEL_4_32 = "points_level_4_32";
    private static final String POINTS_LEVEL_4_33 = "points_level_4_33";
    private static final String POINTS_LEVEL_4_34 = "points_level_4_34";
    private static final String POINTS_LEVEL_4_35 = "points_level_4_35";
    private static final String POINTS_LEVEL_4_36 = "points_level_4_36";
    private static final String POINTS_LEVEL_4_37 = "points_level_4_37";
    private static final String POINTS_LEVEL_4_38 = "points_level_4_38";
    private static final String POINTS_LEVEL_4_39 = "points_level_4_39";
    private static final String POINTS_LEVEL_4_40 = "points_level_4_30";
    private static final String POINTS_LEVEL_4_41 = "points_level_4_41";
    private static final String POINTS_LEVEL_4_42 = "points_level_4_42";
    private static final String POINTS_LEVEL_4_43 = "points_level_4_43";
    private static final String POINTS_LEVEL_4_44 = "points_level_4_44";
    private static final String POINTS_LEVEL_4_45 = "points_level_4_45";
    private static final String POINTS_LEVEL_4_46 = "points_level_4_46";
    private static final String POINTS_LEVEL_4_47 = "points_level_4_47";
    private static final String POINTS_LEVEL_4_48 = "points_level_4_48";
    private static final String POINTS_LEVEL_4_49 = "points_level_4_49";
    private static final String POINTS_LEVEL_4_50 = "points_level_4_50";
    private static final String POINTS_LEVEL_4_51 = "points_level_4_51";
    private static final String POINTS_LEVEL_4_52 = "points_level_4_52";
    private static final String POINTS_LEVEL_4_53 = "points_level_4_53";
    private static final String POINTS_LEVEL_4_54 = "points_level_4_54";
    private static final String POINTS_LEVEL_4_55 = "points_level_4_55";
    private static final String POINTS_LEVEL_4_56 = "points_level_4_56";
    private static final String POINTS_LEVEL_4_57 = "points_level_4_57";
    private static final String POINTS_LEVEL_4_58 = "points_level_4_58";
    private static final String POINTS_LEVEL_4_59 = "points_level_4_59";
    private static final String POINTS_LEVEL_4_60 = "points_level_4_70";
    private static final String POINTS_LEVEL_4_61 = "points_level_4_71";
    private static final String POINTS_LEVEL_4_62 = "points_level_4_72";
    private static final String POINTS_LEVEL_4_63 = "points_level_4_73";
    private static final String POINTS_LEVEL_4_64 = "points_level_4_74";
    private static final String POINTS_LEVEL_4_65 = "points_level_4_75";
    private static final String POINTS_LEVEL_4_66 = "points_level_4_76";
    private static final String POINTS_LEVEL_4_67 = "points_level_4_77";
    private static final String POINTS_LEVEL_4_68 = "points_level_4_78";
    private static final String POINTS_LEVEL_4_69 = "points_level_4_79";
    private static final String POINTS_LEVEL_4_70 = "points_level_4_70";
    private static final String POINTS_LEVEL_4_71 = "points_level_4_81";
    private static final String POINTS_LEVEL_4_72 = "points_level_4_82";
    private static final String POINTS_LEVEL_4_73 = "points_level_4_83";
    private static final String POINTS_LEVEL_4_74 = "points_level_4_84";
    private static final String POINTS_LEVEL_4_75 = "points_level_4_85";
    private static final String POINTS_LEVEL_4_76 = "points_level_4_86";
    private static final String POINTS_LEVEL_4_77 = "points_level_4_87";
    private static final String POINTS_LEVEL_4_78 = "points_level_4_88";
    private static final String POINTS_LEVEL_4_79 = "points_level_4_89";
    private static final String POINTS_LEVEL_4_80 = "points_level_4_89";
    private static final String POINTS_LEVEL_4_81 = "points_level_4_81";
    private static final String POINTS_LEVEL_4_82 = "points_level_4_82";
    private static final String POINTS_LEVEL_4_83 = "points_level_4_83";
    private static final String POINTS_LEVEL_4_84 = "points_level_4_84";
    private static final String POINTS_LEVEL_4_85 = "points_level_4_85";
    private static final String POINTS_LEVEL_4_86 = "points_level_4_86";
    private static final String POINTS_LEVEL_4_87 = "points_level_4_87";
    private static final String POINTS_LEVEL_4_88 = "points_level_4_88";
    private static final String POINTS_LEVEL_4_89 = "points_level_4_89";
    private static final String POINTS_LEVEL_4_90 = "points_level_4_90";
    private static final String POINTS_LEVEL_4_91 = "points_level_4_91";
    private static final String POINTS_LEVEL_4_92 = "points_level_4_92";
    private static final String POINTS_LEVEL_4_93 = "points_level_4_93";
    private static final String POINTS_LEVEL_4_94 = "points_level_4_94";
    private static final String POINTS_LEVEL_4_95 = "points_level_4_95";
    private static final String POINTS_LEVEL_4_96 = "points_level_4_96";
    private static final String POINTS_LEVEL_4_97 = "points_level_4_97";
    private static final String POINTS_LEVEL_4_98 = "points_level_4_98";
    private static final String POINTS_LEVEL_4_99 = "points_level_4_99";
    private static final String POINTS_LEVEL_4_100 ="points_level_4_100";
    private static final String POINTS_LEVEL_5_1 =  "points_level_5_1";
    private static final String POINTS_LEVEL_5_2 =  "points_level_5_2";
    private static final String POINTS_LEVEL_5_3 =  "points_level_5_3";
    private static final String POINTS_LEVEL_5_4 =  "points_level_5_4";
    private static final String POINTS_LEVEL_5_5 =  "points_level_5_5";
    private static final String POINTS_LEVEL_5_6 =  "points_level_5_6";
    private static final String POINTS_LEVEL_5_7 =  "points_level_5_7";
    private static final String POINTS_LEVEL_5_8 =  "points_level_5_8";
    private static final String POINTS_LEVEL_5_9 =  "points_level_5_9";
    private static final String POINTS_LEVEL_5_10 = "points_level_5_10";
    private static final String POINTS_LEVEL_5_11 = "points_level_5_11";
    private static final String POINTS_LEVEL_5_12 = "points_level_5_12";
    private static final String POINTS_LEVEL_5_13 = "points_level_5_13";
    private static final String POINTS_LEVEL_5_14 = "points_level_5_14";
    private static final String POINTS_LEVEL_5_15 = "points_level_5_15";
    private static final String POINTS_LEVEL_5_16 = "points_level_5_16";
    private static final String POINTS_LEVEL_5_17 = "points_level_5_17";
    private static final String POINTS_LEVEL_5_18 = "points_level_5_18";
    private static final String POINTS_LEVEL_5_19 = "points_level_5_19";
    private static final String POINTS_LEVEL_5_20 = "points_level_5_20";
    private static final String POINTS_LEVEL_5_21 = "points_level_5_21";
    private static final String POINTS_LEVEL_5_22 = "points_level_5_22";
    private static final String POINTS_LEVEL_5_23 = "points_level_5_23";
    private static final String POINTS_LEVEL_5_24 = "points_level_5_24";
    private static final String POINTS_LEVEL_5_25 = "points_level_5_25";
    private static final String POINTS_LEVEL_5_26 = "points_level_5_26";
    private static final String POINTS_LEVEL_5_27 = "points_level_5_27";
    private static final String POINTS_LEVEL_5_28 = "points_level_5_28";
    private static final String POINTS_LEVEL_5_29 = "points_level_5_29";
    private static final String POINTS_LEVEL_5_30 = "points_level_5_20";
    private static final String POINTS_LEVEL_5_31 = "points_level_5_31";
    private static final String POINTS_LEVEL_5_32 = "points_level_5_32";
    private static final String POINTS_LEVEL_5_33 = "points_level_5_33";
    private static final String POINTS_LEVEL_5_34 = "points_level_5_34";
    private static final String POINTS_LEVEL_5_35 = "points_level_5_35";
    private static final String POINTS_LEVEL_5_36 = "points_level_5_36";
    private static final String POINTS_LEVEL_5_37 = "points_level_5_37";
    private static final String POINTS_LEVEL_5_38 = "points_level_5_38";
    private static final String POINTS_LEVEL_5_39 = "points_level_5_39";
    private static final String POINTS_LEVEL_5_40 = "points_level_5_30";
    private static final String POINTS_LEVEL_5_41 = "points_level_5_41";
    private static final String POINTS_LEVEL_5_42 = "points_level_5_42";
    private static final String POINTS_LEVEL_5_43 = "points_level_5_43";
    private static final String POINTS_LEVEL_5_44 = "points_level_5_44";
    private static final String POINTS_LEVEL_5_45 = "points_level_5_45";
    private static final String POINTS_LEVEL_5_46 = "points_level_5_46";
    private static final String POINTS_LEVEL_5_47 = "points_level_5_47";
    private static final String POINTS_LEVEL_5_48 = "points_level_5_48";
    private static final String POINTS_LEVEL_5_49 = "points_level_5_49";
    private static final String POINTS_LEVEL_5_50 = "points_level_5_50";
    private static final String POINTS_LEVEL_5_51 = "points_level_5_51";
    private static final String POINTS_LEVEL_5_52 = "points_level_5_52";
    private static final String POINTS_LEVEL_5_53 = "points_level_5_53";
    private static final String POINTS_LEVEL_5_54 = "points_level_5_54";
    private static final String POINTS_LEVEL_5_55 = "points_level_5_55";
    private static final String POINTS_LEVEL_5_56 = "points_level_5_56";
    private static final String POINTS_LEVEL_5_57 = "points_level_5_57";
    private static final String POINTS_LEVEL_5_58 = "points_level_5_58";
    private static final String POINTS_LEVEL_5_59 = "points_level_5_59";
    private static final String POINTS_LEVEL_5_60 = "points_level_5_70";
    private static final String POINTS_LEVEL_5_61 = "points_level_5_71";
    private static final String POINTS_LEVEL_5_62 = "points_level_5_72";
    private static final String POINTS_LEVEL_5_63 = "points_level_5_73";
    private static final String POINTS_LEVEL_5_64 = "points_level_5_74";
    private static final String POINTS_LEVEL_5_65 = "points_level_5_75";
    private static final String POINTS_LEVEL_5_66 = "points_level_5_76";
    private static final String POINTS_LEVEL_5_67 = "points_level_5_77";
    private static final String POINTS_LEVEL_5_68 = "points_level_5_78";
    private static final String POINTS_LEVEL_5_69 = "points_level_5_79";
    private static final String POINTS_LEVEL_5_70 = "points_level_5_70";
    private static final String POINTS_LEVEL_5_71 = "points_level_5_81";
    private static final String POINTS_LEVEL_5_72 = "points_level_5_82";
    private static final String POINTS_LEVEL_5_73 = "points_level_5_83";
    private static final String POINTS_LEVEL_5_74 = "points_level_5_84";
    private static final String POINTS_LEVEL_5_75 = "points_level_5_85";
    private static final String POINTS_LEVEL_5_76 = "points_level_5_86";
    private static final String POINTS_LEVEL_5_77 = "points_level_5_87";
    private static final String POINTS_LEVEL_5_78 = "points_level_5_88";
    private static final String POINTS_LEVEL_5_79 = "points_level_5_89";
    private static final String POINTS_LEVEL_5_80 = "points_level_5_89";
    private static final String POINTS_LEVEL_5_81 = "points_level_5_81";
    private static final String POINTS_LEVEL_5_82 = "points_level_5_82";
    private static final String POINTS_LEVEL_5_83 = "points_level_5_83";
    private static final String POINTS_LEVEL_5_84 = "points_level_5_84";
    private static final String POINTS_LEVEL_5_85 = "points_level_5_85";
    private static final String POINTS_LEVEL_5_86 = "points_level_5_86";
    private static final String POINTS_LEVEL_5_87 = "points_level_5_87";
    private static final String POINTS_LEVEL_5_88 = "points_level_5_88";
    private static final String POINTS_LEVEL_5_89 = "points_level_5_89";
    private static final String POINTS_LEVEL_5_90 = "points_level_5_90";
    private static final String POINTS_LEVEL_5_91 = "points_level_5_91";
    private static final String POINTS_LEVEL_5_92 = "points_level_5_92";
    private static final String POINTS_LEVEL_5_93 = "points_level_5_93";
    private static final String POINTS_LEVEL_5_94 = "points_level_5_94";
    private static final String POINTS_LEVEL_5_95 = "points_level_5_95";
    private static final String POINTS_LEVEL_5_96 = "points_level_5_96";
    private static final String POINTS_LEVEL_5_97 = "points_level_5_97";
    private static final String POINTS_LEVEL_5_98 = "points_level_5_98";
    private static final String POINTS_LEVEL_5_99 = "points_level_5_99";
    private static final String POINTS_LEVEL_5_100 ="points_level_5_100";
    private static final String POINTS_LEVEL_6_1 =  "points_level_6_1";
    private static final String POINTS_LEVEL_6_2 =  "points_level_6_2";
    private static final String POINTS_LEVEL_6_3 =  "points_level_6_3";
    private static final String POINTS_LEVEL_6_4 =  "points_level_6_4";
    private static final String POINTS_LEVEL_6_5 =  "points_level_6_5";
    private static final String POINTS_LEVEL_6_6 =  "points_level_6_6";
    private static final String POINTS_LEVEL_6_7 =  "points_level_6_7";
    private static final String POINTS_LEVEL_6_8 =  "points_level_6_8";
    private static final String POINTS_LEVEL_6_9 =  "points_level_6_9";
    private static final String POINTS_LEVEL_6_10 = "points_level_6_10";
    private static final String POINTS_LEVEL_6_11 = "points_level_6_11";
    private static final String POINTS_LEVEL_6_12 = "points_level_6_12";
    private static final String POINTS_LEVEL_6_13 = "points_level_6_13";
    private static final String POINTS_LEVEL_6_14 = "points_level_6_14";
    private static final String POINTS_LEVEL_6_15 = "points_level_6_15";
    private static final String POINTS_LEVEL_6_16 = "points_level_6_16";
    private static final String POINTS_LEVEL_6_17 = "points_level_6_17";
    private static final String POINTS_LEVEL_6_18 = "points_level_6_18";
    private static final String POINTS_LEVEL_6_19 = "points_level_6_19";
    private static final String POINTS_LEVEL_6_20 = "points_level_6_20";
    private static final String POINTS_LEVEL_6_21 = "points_level_6_21";
    private static final String POINTS_LEVEL_6_22 = "points_level_6_22";
    private static final String POINTS_LEVEL_6_23 = "points_level_6_23";
    private static final String POINTS_LEVEL_6_24 = "points_level_6_24";
    private static final String POINTS_LEVEL_6_25 = "points_level_6_25";
    private static final String POINTS_LEVEL_6_26 = "points_level_6_26";
    private static final String POINTS_LEVEL_6_27 = "points_level_6_27";
    private static final String POINTS_LEVEL_6_28 = "points_level_6_28";
    private static final String POINTS_LEVEL_6_29 = "points_level_6_29";
    private static final String POINTS_LEVEL_6_30 = "points_level_6_20";
    private static final String POINTS_LEVEL_6_31 = "points_level_6_31";
    private static final String POINTS_LEVEL_6_32 = "points_level_6_32";
    private static final String POINTS_LEVEL_6_33 = "points_level_6_33";
    private static final String POINTS_LEVEL_6_34 = "points_level_6_34";
    private static final String POINTS_LEVEL_6_35 = "points_level_6_35";
    private static final String POINTS_LEVEL_6_36 = "points_level_6_36";
    private static final String POINTS_LEVEL_6_37 = "points_level_6_37";
    private static final String POINTS_LEVEL_6_38 = "points_level_6_38";
    private static final String POINTS_LEVEL_6_39 = "points_level_6_39";
    private static final String POINTS_LEVEL_6_40 = "points_level_6_30";
    private static final String POINTS_LEVEL_6_41 = "points_level_6_41";
    private static final String POINTS_LEVEL_6_42 = "points_level_6_42";
    private static final String POINTS_LEVEL_6_43 = "points_level_6_43";
    private static final String POINTS_LEVEL_6_44 = "points_level_6_44";
    private static final String POINTS_LEVEL_6_45 = "points_level_6_45";
    private static final String POINTS_LEVEL_6_46 = "points_level_6_46";
    private static final String POINTS_LEVEL_6_47 = "points_level_6_47";
    private static final String POINTS_LEVEL_6_48 = "points_level_6_48";
    private static final String POINTS_LEVEL_6_49 = "points_level_6_49";
    private static final String POINTS_LEVEL_6_50 = "points_level_6_50";
    private static final String POINTS_LEVEL_6_51 = "points_level_6_51";
    private static final String POINTS_LEVEL_6_52 = "points_level_6_52";
    private static final String POINTS_LEVEL_6_53 = "points_level_6_53";
    private static final String POINTS_LEVEL_6_54 = "points_level_6_54";
    private static final String POINTS_LEVEL_6_55 = "points_level_6_55";
    private static final String POINTS_LEVEL_6_56 = "points_level_6_56";
    private static final String POINTS_LEVEL_6_57 = "points_level_6_57";
    private static final String POINTS_LEVEL_6_58 = "points_level_6_58";
    private static final String POINTS_LEVEL_6_59 = "points_level_6_59";
    private static final String POINTS_LEVEL_6_60 = "points_level_6_70";
    private static final String POINTS_LEVEL_6_61 = "points_level_6_71";
    private static final String POINTS_LEVEL_6_62 = "points_level_6_72";
    private static final String POINTS_LEVEL_6_63 = "points_level_6_73";
    private static final String POINTS_LEVEL_6_64 = "points_level_6_74";
    private static final String POINTS_LEVEL_6_65 = "points_level_6_75";
    private static final String POINTS_LEVEL_6_66 = "points_level_6_76";
    private static final String POINTS_LEVEL_6_67 = "points_level_6_77";
    private static final String POINTS_LEVEL_6_68 = "points_level_6_78";
    private static final String POINTS_LEVEL_6_69 = "points_level_6_79";
    private static final String POINTS_LEVEL_6_70 = "points_level_6_70";
    private static final String POINTS_LEVEL_6_71 = "points_level_6_71";
    private static final String POINTS_LEVEL_6_72 = "points_level_6_72";
    private static final String POINTS_LEVEL_6_73 = "points_level_6_73";
    private static final String POINTS_LEVEL_6_74 = "points_level_6_74";
    private static final String POINTS_LEVEL_6_75 = "points_level_6_75";
    private static final String POINTS_LEVEL_6_76 = "points_level_6_76";
    private static final String POINTS_LEVEL_6_77 = "points_level_6_77";
    private static final String POINTS_LEVEL_6_78 = "points_level_6_78";
    private static final String POINTS_LEVEL_6_79 = "points_level_6_79";
    private static final String POINTS_LEVEL_6_80 = "points_level_6_70";
    private static final String POINTS_LEVEL_6_81 = "points_level_6_81";
    private static final String POINTS_LEVEL_6_82 = "points_level_6_82";
    private static final String POINTS_LEVEL_6_83 = "points_level_6_83";
    private static final String POINTS_LEVEL_6_84 = "points_level_6_84";
    private static final String POINTS_LEVEL_6_85 = "points_level_6_85";
    private static final String POINTS_LEVEL_6_86 = "points_level_6_86";
    private static final String POINTS_LEVEL_6_87 = "points_level_6_87";
    private static final String POINTS_LEVEL_6_88 = "points_level_6_88";
    private static final String POINTS_LEVEL_6_89 = "points_level_6_89";
    private static final String POINTS_LEVEL_6_90 = "points_level_6_90";
    private static final String POINTS_LEVEL_6_91 = "points_level_6_91";
    private static final String POINTS_LEVEL_6_92 = "points_level_6_92";
    private static final String POINTS_LEVEL_6_93 = "points_level_6_93";
    private static final String POINTS_LEVEL_6_94 = "points_level_6_94";
    private static final String POINTS_LEVEL_6_95 = "points_level_6_95";
    private static final String POINTS_LEVEL_6_96 = "points_level_6_96";
    private static final String POINTS_LEVEL_6_97 = "points_level_6_97";
    private static final String POINTS_LEVEL_6_98 = "points_level_6_98";
    private static final String POINTS_LEVEL_6_99 = "points_level_6_99";
    private static final String POINTS_LEVEL_6_100 ="points_level_6_100";
    private static final String TIME_RECORD_1 = "time_record_1";
    private static final String TIME_RECORD_2 = "time_record_2";
    private static final String TIME_RECORD_3 = "time_record_3";
    private static final String TIME_RECORD_4 = "time_record_4";
    private static final String TIME_RECORD_5 = "time_record_5";
    private static final String TIME_RECORD_6 = "time_record_6";
    private static final String QUESTION_RECORD_1 = "question_record_1";
    private static final String QUESTION_RECORD_2 = "question_record_2";
    private static final String QUESTION_RECORD_3 = "question_record_3";
    private static final String QUESTION_RECORD_4 = "question_record_4";
    private static final String QUESTION_RECORD_5 = "question_record_5";
    private static final String QUESTION_RECORD_6 = "question_record_6";
    public static final String IS_LAST_LEVEL_COMPLETED = "is_last_level_completed";
    public static final String LAST_LEVEL_SCORE = "last_level_score";
    public static final String COUNT_QUESTION_COMPLETED = "count_question_completed";
    private static final String COUNT_RIGHT_ANSWARE_QUESTIONS = "count_right_answare_questions";
    private static final String COUNT_COINS_PLAYTIME = "count_coins_playtime";
    private static final String NIGHT_MODE = "night_mode";

    public static void setNightMode(Context context, Boolean mode) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putBoolean(NIGHT_MODE, mode);
        prefEditor.apply();
    }
    public static Boolean getNightMode(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(NIGHT_MODE, false);
    }

    public static void setPlayenName(Context context, String name) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putString(PLAYER_NAME, name);
        prefEditor.apply();
    }

    public static String getPlayerName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getString(PLAYER_NAME, "");
    }


    public static void setVibration(Context context, Boolean result) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putBoolean(VIBRATION, result);
        prefEditor.apply();
    }


    public static boolean getVibration(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(VIBRATION, true);
    }

    public static void setSoundEnableDisable(Context context, Boolean result) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putBoolean(SOUND_ONOFF, result);
        prefEditor.apply();
    }



    public static boolean getSoundEnableDisable(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(SOUND_ONOFF, true);
    }

    public static void setMusicEnableDisable(Context context, Boolean result) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putBoolean(SHOW_MUSIC_ONOFF, result);
        prefEditor.apply();
    }

    public static boolean getMusicEnableDisable(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(SHOW_MUSIC_ONOFF,
                false);
    }

    public static void setLan(Context context, Boolean result) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putBoolean(LANG, result);
        prefEditor.apply();
    }


    public static boolean getLan(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(LANG,
                true);
    }

    public static void setCountCoinsPlaytime(Context context, int coins) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(COUNT_COINS_PLAYTIME, coins);
        prefEditor.apply();
    }

    public static int getCountCoinsPlayTime(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(COUNT_COINS_PLAYTIME, 0);
    }

    public static void setScore(Context context, int totalScore) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(TOTAL_SCORE, totalScore);
        prefEditor.apply();
    }
    public static void setQuizList(Context context, String quiz) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putString(LISTQUIZ, quiz);
        prefEditor.apply();
    }
    public static String getListQuiz(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getString(LISTQUIZ, "");
    }




    public static int getScore(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(TOTAL_SCORE, 0);
    }

    public static void setPoint(Context context, int point) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(POINT, point);
        prefEditor.apply();
    }

    public static int getSchoolGrade(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(SCHOOL_GRADE, 1);
    }

    public static void setSchoolGrade(Context context, int level) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(SCHOOL_GRADE, level);
        prefEditor.apply();
    }


    public static int getPoint(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(POINT, 6);

    }
    public static int getLastUpdateScore(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(LAST_UPDATE_SCORE, 0);

    }
    public static void setLastUpdateScore(Context context, int score) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(LAST_UPDATE_SCORE, score);
        prefEditor.apply();
    }

    public static void setNoCompletedLevel(Context context, int completedLevel, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        switch (schoolGrade) {
            case 1:
                prefEditor.putInt(LEVEL_COMPLETED_1, completedLevel);
                break;
            case 2:
                prefEditor.putInt(LEVEL_COMPLETED_2, completedLevel);
                break;
            case 3:
                prefEditor.putInt(LEVEL_COMPLETED_3, completedLevel);
                break;
            case 4:
                prefEditor.putInt(LEVEL_COMPLETED_4, completedLevel);
                break;
            case 5:
                prefEditor.putInt(LEVEL_COMPLETED_5, completedLevel);
                break;
            case 6:
                prefEditor.putInt(LEVEL_COMPLETED, completedLevel);
                break;
        }
        prefEditor.apply();
    }


    public static int getNoCompletedLevel(Context context, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        int level = 0;
        switch (schoolGrade) {
            case 1:
                level = prefs.getInt(LEVEL_COMPLETED_1, 1);
                break;
            case 2:
                level = prefs.getInt(LEVEL_COMPLETED_2, 1);
                break;
            case 3:
                level = prefs.getInt(LEVEL_COMPLETED_3, 1);
                break;
            case 4:
                level = prefs.getInt(LEVEL_COMPLETED_4, 1);
                break;
            case 5:
                level = prefs.getInt(LEVEL_COMPLETED_5, 1);
                break;
            case 6:
                level = prefs.getInt(LEVEL_COMPLETED, 1);
                break;
        }
        return level;

    }

    public static void setRightAns(Context context, int NoofrightAns) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(COUNT_RIGHT_ANSWARE_QUESTIONS, NoofrightAns);
        prefEditor.apply();
    }

    public static int getRightAns(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(COUNT_RIGHT_ANSWARE_QUESTIONS, 0);

    }

    public static void setCountQuestionCompleted(Context context, int countquetioncompleted) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putInt(COUNT_QUESTION_COMPLETED, countquetioncompleted);
        prefEditor.apply();
    }

    public static int getCountQuestionCompleted(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        return prefs.getInt(COUNT_QUESTION_COMPLETED, 0);

    }

    public static void setLevelScore(Context context, int schoolGrade, int level, int score) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        switch (schoolGrade) {
            case 1:
                switch (level) {
                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_1_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_1_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_1_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_1_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_1_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_1_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_1_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_1_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_1_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_1_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_1_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_1_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_1_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_1_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_1_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_1_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_1_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_1_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_1_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_1_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_1_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_1_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_1_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_1_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_1_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_1_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_1_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_1_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_1_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_1_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_1_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_1_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_1_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_1_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_1_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_1_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_1_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_1_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_1_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_1_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_1_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_1_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_1_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_1_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_1_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_1_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_1_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_1_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_1_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_1_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_1_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_1_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_1_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_1_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_1_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_1_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_1_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_1_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_1_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_1_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_1_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_1_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_1_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_1_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_1_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_1_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_1_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_1_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_1_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_1_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_1_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_1_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_1_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_1_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_1_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_1_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_1_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_1_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_1_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_1_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_1_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_1_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_1_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_1_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_1_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_1_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_1_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_1_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_1_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_1_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_1_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_1_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_1_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_1_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_1_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_1_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_1_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_1_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_1_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_1_100, score);
                        break;

                }

                break;
            case 2:
                switch (level) {
                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_2_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_2_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_2_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_2_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_2_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_2_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_2_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_2_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_2_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_2_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_2_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_2_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_2_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_2_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_2_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_2_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_2_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_2_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_2_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_2_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_2_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_2_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_2_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_2_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_2_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_2_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_2_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_2_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_2_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_2_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_2_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_2_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_2_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_2_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_2_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_2_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_2_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_2_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_2_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_2_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_2_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_2_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_2_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_2_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_2_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_2_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_2_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_2_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_2_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_2_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_2_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_2_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_2_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_2_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_2_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_2_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_2_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_2_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_2_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_2_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_2_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_2_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_2_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_2_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_2_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_2_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_2_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_2_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_2_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_2_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_2_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_2_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_2_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_2_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_2_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_2_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_2_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_2_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_2_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_2_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_2_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_2_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_2_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_2_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_2_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_2_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_2_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_2_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_2_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_2_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_2_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_2_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_2_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_2_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_2_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_2_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_2_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_2_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_2_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_2_100, score);
                        break;

                }

                break;
            case 3:
                switch (level) {
                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_3_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_3_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_3_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_3_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_3_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_3_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_3_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_3_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_3_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_3_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_3_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_3_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_3_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_3_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_3_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_3_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_3_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_3_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_3_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_3_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_3_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_3_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_3_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_3_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_3_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_3_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_3_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_3_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_3_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_3_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_3_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_3_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_3_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_3_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_3_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_3_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_3_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_3_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_3_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_3_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_3_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_3_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_3_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_3_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_3_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_3_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_3_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_3_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_3_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_3_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_3_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_3_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_3_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_3_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_3_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_3_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_3_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_3_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_3_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_3_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_3_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_3_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_3_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_3_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_3_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_3_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_3_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_3_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_3_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_3_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_3_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_3_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_3_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_3_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_3_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_3_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_3_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_3_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_3_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_3_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_3_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_3_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_3_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_3_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_3_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_3_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_3_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_3_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_3_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_3_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_3_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_3_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_3_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_3_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_3_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_3_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_3_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_3_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_3_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_3_100, score);
                        break;
                }
                break;
            case 4:
                switch (level) {

                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_4_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_4_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_4_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_4_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_4_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_4_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_4_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_4_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_4_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_4_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_4_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_4_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_4_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_4_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_4_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_4_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_4_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_4_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_4_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_4_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_4_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_4_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_4_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_4_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_4_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_4_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_4_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_4_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_4_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_4_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_4_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_4_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_4_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_4_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_4_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_4_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_4_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_4_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_4_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_4_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_4_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_4_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_4_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_4_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_4_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_4_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_4_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_4_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_4_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_4_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_4_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_4_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_4_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_4_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_4_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_4_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_4_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_4_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_4_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_4_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_4_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_4_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_4_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_4_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_4_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_4_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_4_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_4_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_4_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_4_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_4_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_4_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_4_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_4_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_4_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_4_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_4_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_4_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_4_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_4_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_4_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_4_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_4_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_4_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_4_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_4_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_4_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_4_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_4_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_4_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_4_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_4_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_4_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_4_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_4_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_4_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_4_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_4_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_4_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_4_100, score);
                        break;

                }

                break;
            case 5:
                switch (level) {

                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_5_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_5_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_5_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_5_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_5_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_5_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_5_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_5_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_5_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_5_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_5_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_5_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_5_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_5_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_5_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_5_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_5_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_5_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_5_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_5_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_5_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_5_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_5_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_5_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_5_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_5_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_5_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_5_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_5_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_5_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_5_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_5_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_5_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_5_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_5_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_5_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_5_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_5_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_5_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_5_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_5_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_5_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_5_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_5_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_5_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_5_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_5_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_5_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_5_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_5_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_5_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_5_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_5_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_5_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_5_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_5_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_5_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_5_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_5_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_5_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_5_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_5_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_5_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_5_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_5_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_5_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_5_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_5_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_5_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_5_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_5_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_5_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_5_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_5_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_5_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_5_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_5_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_5_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_5_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_5_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_5_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_5_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_5_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_5_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_5_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_5_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_5_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_5_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_5_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_5_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_5_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_5_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_5_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_5_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_5_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_5_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_5_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_5_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_5_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_5_100, score);
                        break;

                }
                break;
            case 6:
                switch (level) {

                    case 1:
                        prefEditor.putInt(SCORE_LEVEL_6_1, score);
                        break;
                    case 2:
                        prefEditor.putInt(SCORE_LEVEL_6_2, score);
                        break;
                    case 3:
                        prefEditor.putInt(SCORE_LEVEL_6_3, score);
                        break;
                    case 4:
                        prefEditor.putInt(SCORE_LEVEL_6_4, score);
                        break;
                    case 5:
                        prefEditor.putInt(SCORE_LEVEL_6_5, score);
                        break;
                    case 6:
                        prefEditor.putInt(SCORE_LEVEL_6_6, score);
                        break;
                    case 7:
                        prefEditor.putInt(SCORE_LEVEL_6_7, score);
                        break;
                    case 8:
                        prefEditor.putInt(SCORE_LEVEL_6_8, score);
                        break;
                    case 9:
                        prefEditor.putInt(SCORE_LEVEL_6_9, score);
                        break;
                    case 10:
                        prefEditor.putInt(SCORE_LEVEL_6_10, score);
                        break;
                    case 11:
                        prefEditor.putInt(SCORE_LEVEL_6_11, score);
                        break;
                    case 12:
                        prefEditor.putInt(SCORE_LEVEL_6_12, score);
                        break;
                    case 13:
                        prefEditor.putInt(SCORE_LEVEL_6_13, score);
                        break;
                    case 14:
                        prefEditor.putInt(SCORE_LEVEL_6_14, score);
                        break;
                    case 15:
                        prefEditor.putInt(SCORE_LEVEL_6_15, score);
                        break;
                    case 16:
                        prefEditor.putInt(SCORE_LEVEL_6_16, score);
                        break;
                    case 17:
                        prefEditor.putInt(SCORE_LEVEL_6_17, score);
                        break;
                    case 18:
                        prefEditor.putInt(SCORE_LEVEL_6_18, score);
                        break;
                    case 19:
                        prefEditor.putInt(SCORE_LEVEL_6_19, score);
                        break;
                    case 20:
                        prefEditor.putInt(SCORE_LEVEL_6_20, score);
                        break;
                    case 21:
                        prefEditor.putInt(SCORE_LEVEL_6_21, score);
                        break;
                    case 22:
                        prefEditor.putInt(SCORE_LEVEL_6_22, score);
                        break;
                    case 23:
                        prefEditor.putInt(SCORE_LEVEL_6_23, score);
                        break;
                    case 24:
                        prefEditor.putInt(SCORE_LEVEL_6_24, score);
                        break;
                    case 25:
                        prefEditor.putInt(SCORE_LEVEL_6_25, score);
                        break;
                    case 26:
                        prefEditor.putInt(SCORE_LEVEL_6_26, score);
                        break;
                    case 27:
                        prefEditor.putInt(SCORE_LEVEL_6_27, score);
                        break;
                    case 28:
                        prefEditor.putInt(SCORE_LEVEL_6_28, score);
                        break;
                    case 29:
                        prefEditor.putInt(SCORE_LEVEL_6_29, score);
                        break;
                    case 30:
                        prefEditor.putInt(SCORE_LEVEL_6_30, score);
                        break;
                    case 31:
                        prefEditor.putInt(SCORE_LEVEL_6_31, score);
                        break;
                    case 32:
                        prefEditor.putInt(SCORE_LEVEL_6_32, score);
                        break;
                    case 33:
                        prefEditor.putInt(SCORE_LEVEL_6_33, score);
                        break;
                    case 34:
                        prefEditor.putInt(SCORE_LEVEL_6_34, score);
                        break;
                    case 35:
                        prefEditor.putInt(SCORE_LEVEL_6_35, score);
                        break;
                    case 36:
                        prefEditor.putInt(SCORE_LEVEL_6_36, score);
                        break;
                    case 37:
                        prefEditor.putInt(SCORE_LEVEL_6_37, score);
                        break;
                    case 38:
                        prefEditor.putInt(SCORE_LEVEL_6_38, score);
                        break;
                    case 39:
                        prefEditor.putInt(SCORE_LEVEL_6_39, score);
                        break;
                    case 40:
                        prefEditor.putInt(SCORE_LEVEL_6_40, score);
                        break;
                    case 41:
                        prefEditor.putInt(SCORE_LEVEL_6_41, score);
                        break;
                    case 42:
                        prefEditor.putInt(SCORE_LEVEL_6_42, score);
                        break;
                    case 43:
                        prefEditor.putInt(SCORE_LEVEL_6_43, score);
                        break;
                    case 44:
                        prefEditor.putInt(SCORE_LEVEL_6_44, score);
                        break;
                    case 45:
                        prefEditor.putInt(SCORE_LEVEL_6_45, score);
                        break;
                    case 46:
                        prefEditor.putInt(SCORE_LEVEL_6_46, score);
                        break;
                    case 47:
                        prefEditor.putInt(SCORE_LEVEL_6_47, score);
                        break;
                    case 48:
                        prefEditor.putInt(SCORE_LEVEL_6_48, score);
                        break;
                    case 49:
                        prefEditor.putInt(SCORE_LEVEL_6_49, score);
                        break;
                    case 50:
                        prefEditor.putInt(SCORE_LEVEL_6_50, score);
                        break;
                    case 51:
                        prefEditor.putInt(SCORE_LEVEL_6_51, score);
                        break;
                    case 52:
                        prefEditor.putInt(SCORE_LEVEL_6_52, score);
                        break;
                    case 53:
                        prefEditor.putInt(SCORE_LEVEL_6_53, score);
                        break;
                    case 54:
                        prefEditor.putInt(SCORE_LEVEL_6_54, score);
                        break;
                    case 55:
                        prefEditor.putInt(SCORE_LEVEL_6_55, score);
                        break;
                    case 56:
                        prefEditor.putInt(SCORE_LEVEL_6_56, score);
                        break;
                    case 57:
                        prefEditor.putInt(SCORE_LEVEL_6_57, score);
                        break;
                    case 58:
                        prefEditor.putInt(SCORE_LEVEL_6_58, score);
                        break;
                    case 59:
                        prefEditor.putInt(SCORE_LEVEL_6_59, score);
                        break;
                    case 60:
                        prefEditor.putInt(SCORE_LEVEL_6_60, score);
                        break;
                    case 61:
                        prefEditor.putInt(SCORE_LEVEL_6_61, score);
                        break;
                    case 62:
                        prefEditor.putInt(SCORE_LEVEL_6_62, score);
                        break;
                    case 63:
                        prefEditor.putInt(SCORE_LEVEL_6_63, score);
                        break;
                    case 64:
                        prefEditor.putInt(SCORE_LEVEL_6_64, score);
                        break;
                    case 65:
                        prefEditor.putInt(SCORE_LEVEL_6_65, score);
                        break;
                    case 66:
                        prefEditor.putInt(SCORE_LEVEL_6_66, score);
                        break;
                    case 67:
                        prefEditor.putInt(SCORE_LEVEL_6_67, score);
                        break;
                    case 68:
                        prefEditor.putInt(SCORE_LEVEL_6_68, score);
                        break;
                    case 69:
                        prefEditor.putInt(SCORE_LEVEL_6_69, score);
                        break;
                    case 70:
                        prefEditor.putInt(SCORE_LEVEL_6_70, score);
                        break;
                    case 71:
                        prefEditor.putInt(SCORE_LEVEL_6_71, score);
                        break;
                    case 72:
                        prefEditor.putInt(SCORE_LEVEL_6_72, score);
                        break;
                    case 73:
                        prefEditor.putInt(SCORE_LEVEL_6_73, score);
                        break;
                    case 74:
                        prefEditor.putInt(SCORE_LEVEL_6_74, score);
                        break;
                    case 75:
                        prefEditor.putInt(SCORE_LEVEL_6_75, score);
                        break;
                    case 76:
                        prefEditor.putInt(SCORE_LEVEL_6_76, score);
                        break;
                    case 77:
                        prefEditor.putInt(SCORE_LEVEL_6_77, score);
                        break;
                    case 78:
                        prefEditor.putInt(SCORE_LEVEL_6_78, score);
                        break;
                    case 79:
                        prefEditor.putInt(SCORE_LEVEL_6_79, score);
                        break;
                    case 80:
                        prefEditor.putInt(SCORE_LEVEL_6_80, score);
                        break;
                    case 81:
                        prefEditor.putInt(SCORE_LEVEL_6_81, score);
                        break;
                    case 82:
                        prefEditor.putInt(SCORE_LEVEL_6_82, score);
                        break;
                    case 83:
                        prefEditor.putInt(SCORE_LEVEL_6_83, score);
                        break;
                    case 84:
                        prefEditor.putInt(SCORE_LEVEL_6_84, score);
                        break;
                    case 85:
                        prefEditor.putInt(SCORE_LEVEL_6_85, score);
                        break;
                    case 86:
                        prefEditor.putInt(SCORE_LEVEL_6_86, score);
                        break;
                    case 87:
                        prefEditor.putInt(SCORE_LEVEL_6_87, score);
                        break;
                    case 88:
                        prefEditor.putInt(SCORE_LEVEL_6_88, score);
                        break;
                    case 89:
                        prefEditor.putInt(SCORE_LEVEL_6_89, score);
                        break;
                    case 90:
                        prefEditor.putInt(SCORE_LEVEL_6_90, score);
                        break;
                    case 91:
                        prefEditor.putInt(SCORE_LEVEL_6_91, score);
                        break;
                    case 92:
                        prefEditor.putInt(SCORE_LEVEL_6_92, score);
                        break;
                    case 93:
                        prefEditor.putInt(SCORE_LEVEL_6_93, score);
                        break;
                    case 94:
                        prefEditor.putInt(SCORE_LEVEL_6_94, score);
                        break;
                    case 95:
                        prefEditor.putInt(SCORE_LEVEL_6_95, score);
                        break;
                    case 96:
                        prefEditor.putInt(SCORE_LEVEL_6_96, score);
                        break;
                    case 97:
                        prefEditor.putInt(SCORE_LEVEL_6_97, score);
                        break;
                    case 98:
                        prefEditor.putInt(SCORE_LEVEL_6_98, score);
                        break;
                    case 99:
                        prefEditor.putInt(SCORE_LEVEL_6_99, score);
                        break;
                    case 100:
                        prefEditor.putInt(SCORE_LEVEL_6_100, score);
                        break;
                }

        }
        prefEditor.apply();
    }

    public static int getLevelScore(Context context, int schoolGrade, int level) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        int score = 0;
        switch (schoolGrade) {
            case 1:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_1_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_1_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_1_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_1_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_1_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_1_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_1_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_1_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_1_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_1_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_1_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_1_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_1_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_1_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_1_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_1_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_1_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_1_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_1_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_1_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_1_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_1_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_1_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_1_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_1_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_1_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_1_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_1_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_1_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_1_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_1_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_1_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_1_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_1_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_1_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_1_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_1_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_1_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_1_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_1_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_1_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_1_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_1_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_1_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_1_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_1_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_1_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_1_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_1_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_1_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_1_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_1_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_1_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_1_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_1_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_1_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_1_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_1_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_1_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_1_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_1_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_1_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_1_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_1_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_1_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_1_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_1_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_1_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_1_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_1_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_1_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_1_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_1_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_1_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_1_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_1_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_1_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_1_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_1_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_1_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_1_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_1_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_1_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_1_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_1_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_1_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_1_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_1_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_1_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_1_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_1_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_1_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_1_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_1_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_1_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_1_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_1_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_1_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_1_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_1_100, 0);
                        break;
                }
                break;
            case 2:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_2_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_2_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_2_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_2_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_2_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_2_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_2_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_2_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_2_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_2_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_2_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_2_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_2_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_2_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_2_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_2_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_2_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_2_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_2_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_2_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_2_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_2_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_2_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_2_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_2_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_2_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_2_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_2_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_2_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_2_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_2_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_2_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_2_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_2_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_2_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_2_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_2_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_2_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_2_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_2_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_2_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_2_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_2_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_2_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_2_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_2_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_2_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_2_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_2_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_2_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_2_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_2_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_2_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_2_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_2_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_2_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_2_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_2_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_2_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_2_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_2_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_2_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_2_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_2_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_2_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_2_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_2_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_2_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_2_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_2_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_2_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_2_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_2_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_2_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_2_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_2_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_2_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_2_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_2_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_2_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_2_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_2_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_2_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_2_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_2_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_2_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_2_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_2_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_2_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_2_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_2_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_2_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_2_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_2_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_2_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_2_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_2_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_2_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_2_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_2_100, 0);
                        break;

                }
                break;
            case 3:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_3_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_3_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_3_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_3_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_3_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_3_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_3_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_3_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_3_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_3_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_3_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_3_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_3_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_3_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_3_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_3_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_3_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_3_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_3_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_3_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_3_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_3_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_3_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_3_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_3_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_3_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_3_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_3_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_3_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_3_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_3_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_3_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_3_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_3_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_3_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_3_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_3_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_3_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_3_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_3_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_3_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_3_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_3_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_3_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_3_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_3_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_3_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_3_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_3_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_3_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_3_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_3_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_3_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_3_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_3_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_3_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_3_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_3_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_3_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_3_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_3_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_3_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_3_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_3_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_3_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_3_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_3_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_3_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_3_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_3_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_3_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_3_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_3_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_3_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_3_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_3_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_3_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_3_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_3_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_3_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_3_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_3_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_3_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_3_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_3_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_3_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_3_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_3_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_3_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_3_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_3_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_3_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_3_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_3_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_3_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_3_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_3_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_3_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_3_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_3_100, 0);
                        break;

                }
                break;
            case 4:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_4_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_4_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_4_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_4_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_4_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_4_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_4_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_4_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_4_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_4_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_4_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_4_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_4_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_4_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_4_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_4_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_4_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_4_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_4_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_4_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_4_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_4_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_4_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_4_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_4_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_4_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_4_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_4_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_4_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_4_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_4_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_4_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_4_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_4_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_4_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_4_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_4_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_4_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_4_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_4_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_4_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_4_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_4_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_4_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_4_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_4_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_4_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_4_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_4_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_4_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_4_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_4_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_4_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_4_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_4_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_4_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_4_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_4_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_4_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_4_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_4_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_4_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_4_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_4_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_4_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_4_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_4_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_4_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_4_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_4_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_4_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_4_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_4_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_4_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_4_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_4_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_4_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_4_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_4_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_4_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_4_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_4_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_4_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_4_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_4_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_4_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_4_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_4_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_4_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_4_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_4_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_4_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_4_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_4_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_4_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_4_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_4_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_4_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_4_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_4_100, 0);
                        break;

                }
                break;
            case 5:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_5_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_5_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_5_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_5_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_5_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_5_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_5_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_5_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_5_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_5_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_5_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_5_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_5_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_5_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_5_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_5_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_5_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_5_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_5_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_5_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_5_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_5_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_5_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_5_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_5_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_5_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_5_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_5_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_5_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_5_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_5_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_5_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_5_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_5_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_5_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_5_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_5_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_5_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_5_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_5_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_5_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_5_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_5_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_5_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_5_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_5_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_5_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_5_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_5_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_5_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_5_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_5_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_5_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_5_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_5_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_5_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_5_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_5_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_5_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_5_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_5_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_5_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_5_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_5_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_5_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_5_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_5_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_5_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_5_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_5_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_5_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_5_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_5_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_5_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_5_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_5_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_5_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_5_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_5_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_5_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_5_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_5_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_5_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_5_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_5_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_5_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_5_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_5_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_5_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_5_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_5_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_5_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_5_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_5_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_5_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_5_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_5_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_5_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_5_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_5_100, 0);
                        break;

                }
                break;
            case 6:
                switch (level) {
                    case 1:
                        score = prefs.getInt(SCORE_LEVEL_6_1, 0);
                        break;
                    case 2:
                        score = prefs.getInt(SCORE_LEVEL_6_2, 0);
                        break;
                    case 3:
                        score = prefs.getInt(SCORE_LEVEL_6_3, 0);
                        break;
                    case 4:
                        score = prefs.getInt(SCORE_LEVEL_6_4, 0);
                        break;
                    case 5:
                        score = prefs.getInt(SCORE_LEVEL_6_5, 0);
                        break;
                    case 6:
                        score = prefs.getInt(SCORE_LEVEL_6_6, 0);
                        break;
                    case 7:
                        score = prefs.getInt(SCORE_LEVEL_6_7, 0);
                        break;
                    case 8:
                        score = prefs.getInt(SCORE_LEVEL_6_8, 0);
                        break;
                    case 9:
                        score = prefs.getInt(SCORE_LEVEL_6_9, 0);
                        break;
                    case 10:
                        score = prefs.getInt(SCORE_LEVEL_6_10, 0);
                        break;

                    case 11:
                        score = prefs.getInt(SCORE_LEVEL_6_11, 0);
                        break;

                    case 12:
                        score = prefs.getInt(SCORE_LEVEL_6_12, 0);
                        break;

                    case 13:
                        score = prefs.getInt(SCORE_LEVEL_6_13, 0);
                        break;

                    case 14:
                        score = prefs.getInt(SCORE_LEVEL_6_14, 0);
                        break;

                    case 15:
                        score = prefs.getInt(SCORE_LEVEL_6_15, 0);
                        break;

                    case 16:
                        score = prefs.getInt(SCORE_LEVEL_6_16, 0);
                        break;

                    case 17:
                        score = prefs.getInt(SCORE_LEVEL_6_17, 0);
                        break;

                    case 18:
                        score = prefs.getInt(SCORE_LEVEL_6_18, 0);
                        break;

                    case 19:
                        score = prefs.getInt(SCORE_LEVEL_6_19, 0);
                        break;

                    case 20:
                        score = prefs.getInt(SCORE_LEVEL_6_20, 0);
                        break;

                    case 21:
                        score = prefs.getInt(SCORE_LEVEL_6_21, 0);
                        break;

                    case 22:
                        score = prefs.getInt(SCORE_LEVEL_6_22, 0);
                        break;

                    case 23:
                        score = prefs.getInt(SCORE_LEVEL_6_23, 0);
                        break;

                    case 24:
                        score = prefs.getInt(SCORE_LEVEL_6_24, 0);
                        break;

                    case 25:
                        score = prefs.getInt(SCORE_LEVEL_6_25, 0);
                        break;

                    case 26:
                        score = prefs.getInt(SCORE_LEVEL_6_26, 0);
                        break;

                    case 27:
                        score = prefs.getInt(SCORE_LEVEL_6_27, 0);
                        break;

                    case 28:
                        score = prefs.getInt(SCORE_LEVEL_6_28, 0);
                        break;

                    case 29:
                        score = prefs.getInt(SCORE_LEVEL_6_29, 0);
                        break;

                    case 30:
                        score = prefs.getInt(SCORE_LEVEL_6_30, 0);
                        break;

                    case 31:
                        score = prefs.getInt(SCORE_LEVEL_6_31, 0);
                        break;

                    case 32:
                        score = prefs.getInt(SCORE_LEVEL_6_32, 0);
                        break;

                    case 33:
                        score = prefs.getInt(SCORE_LEVEL_6_33, 0);
                        break;

                    case 34:
                        score = prefs.getInt(SCORE_LEVEL_6_34, 0);
                        break;

                    case 35:
                        score = prefs.getInt(SCORE_LEVEL_6_35, 0);
                        break;

                    case 36:
                        score = prefs.getInt(SCORE_LEVEL_6_36, 0);
                        break;

                    case 37:
                        score = prefs.getInt(SCORE_LEVEL_6_37, 0);
                        break;

                    case 38:
                        score = prefs.getInt(SCORE_LEVEL_6_38, 0);
                        break;

                    case 39:
                        score = prefs.getInt(SCORE_LEVEL_6_39, 0);
                        break;

                    case 40:
                        score = prefs.getInt(SCORE_LEVEL_6_40, 0);
                        break;

                    case 41:
                        score = prefs.getInt(SCORE_LEVEL_6_41, 0);
                        break;

                    case 42:
                        score = prefs.getInt(SCORE_LEVEL_6_42, 0);
                        break;

                    case 43:
                        score = prefs.getInt(SCORE_LEVEL_6_43, 0);
                        break;

                    case 44:
                        score = prefs.getInt(SCORE_LEVEL_6_44, 0);
                        break;

                    case 45:
                        score = prefs.getInt(SCORE_LEVEL_6_45, 0);
                        break;

                    case 46:
                        score = prefs.getInt(SCORE_LEVEL_6_46, 0);
                        break;

                    case 47:
                        score = prefs.getInt(SCORE_LEVEL_6_47, 0);
                        break;

                    case 48:
                        score = prefs.getInt(SCORE_LEVEL_6_48, 0);
                        break;

                    case 49:
                        score = prefs.getInt(SCORE_LEVEL_6_49, 0);
                        break;

                    case 50:
                        score = prefs.getInt(SCORE_LEVEL_6_50, 0);
                        break;

                    case 51:
                        score = prefs.getInt(SCORE_LEVEL_6_51, 0);
                        break;

                    case 52:
                        score = prefs.getInt(SCORE_LEVEL_6_52, 0);
                        break;

                    case 53:
                        score = prefs.getInt(SCORE_LEVEL_6_53, 0);
                        break;

                    case 54:
                        score = prefs.getInt(SCORE_LEVEL_6_54, 0);
                        break;

                    case 55:
                        score = prefs.getInt(SCORE_LEVEL_6_55, 0);
                        break;

                    case 56:
                        score = prefs.getInt(SCORE_LEVEL_6_56, 0);
                        break;

                    case 57:
                        score = prefs.getInt(SCORE_LEVEL_6_57, 0);
                        break;

                    case 58:
                        score = prefs.getInt(SCORE_LEVEL_6_58, 0);
                        break;

                    case 59:
                        score = prefs.getInt(SCORE_LEVEL_6_59, 0);
                        break;

                    case 60:
                        score = prefs.getInt(SCORE_LEVEL_6_60, 0);
                        break;

                    case 61:
                        score = prefs.getInt(SCORE_LEVEL_6_61, 0);
                        break;

                    case 62:
                        score = prefs.getInt(SCORE_LEVEL_6_62, 0);
                        break;

                    case 63:
                        score = prefs.getInt(SCORE_LEVEL_6_63, 0);
                        break;

                    case 64:
                        score = prefs.getInt(SCORE_LEVEL_6_64, 0);
                        break;

                    case 65:
                        score = prefs.getInt(SCORE_LEVEL_6_65, 0);
                        break;

                    case 66:
                        score = prefs.getInt(SCORE_LEVEL_6_66, 0);
                        break;

                    case 67:
                        score = prefs.getInt(SCORE_LEVEL_6_67, 0);
                        break;

                    case 68:
                        score = prefs.getInt(SCORE_LEVEL_6_68, 0);
                        break;

                    case 69:
                        score = prefs.getInt(SCORE_LEVEL_6_69, 0);
                        break;

                    case 70:
                        score = prefs.getInt(SCORE_LEVEL_6_70, 0);
                        break;

                    case 71:
                        score = prefs.getInt(SCORE_LEVEL_6_71, 0);
                        break;

                    case 72:
                        score = prefs.getInt(SCORE_LEVEL_6_72, 0);
                        break;

                    case 73:
                        score = prefs.getInt(SCORE_LEVEL_6_73, 0);
                        break;

                    case 74:
                        score = prefs.getInt(SCORE_LEVEL_6_74, 0);
                        break;

                    case 75:
                        score = prefs.getInt(SCORE_LEVEL_6_75, 0);
                        break;

                    case 76:
                        score = prefs.getInt(SCORE_LEVEL_6_76, 0);
                        break;

                    case 77:
                        score = prefs.getInt(SCORE_LEVEL_6_77, 0);
                        break;

                    case 78:
                        score = prefs.getInt(SCORE_LEVEL_6_78, 0);
                        break;

                    case 79:
                        score = prefs.getInt(SCORE_LEVEL_6_79, 0);
                        break;

                    case 80:
                        score = prefs.getInt(SCORE_LEVEL_6_80, 0);
                        break;

                    case 81:
                        score = prefs.getInt(SCORE_LEVEL_6_81, 0);
                        break;

                    case 82:
                        score = prefs.getInt(SCORE_LEVEL_6_82, 0);
                        break;

                    case 83:
                        score = prefs.getInt(SCORE_LEVEL_6_83, 0);
                        break;

                    case 84:
                        score = prefs.getInt(SCORE_LEVEL_6_84, 0);
                        break;

                    case 85:
                        score = prefs.getInt(SCORE_LEVEL_6_85, 0);
                        break;

                    case 86:
                        score = prefs.getInt(SCORE_LEVEL_6_86, 0);
                        break;

                    case 87:
                        score = prefs.getInt(SCORE_LEVEL_6_87, 0);
                        break;

                    case 88:
                        score = prefs.getInt(SCORE_LEVEL_6_88, 0);
                        break;

                    case 89:
                        score = prefs.getInt(SCORE_LEVEL_6_89, 0);
                        break;

                    case 90:
                        score = prefs.getInt(SCORE_LEVEL_6_90, 0);
                        break;

                    case 91:
                        score = prefs.getInt(SCORE_LEVEL_6_91, 0);
                        break;

                    case 92:
                        score = prefs.getInt(SCORE_LEVEL_6_92, 0);
                        break;

                    case 93:
                        score = prefs.getInt(SCORE_LEVEL_6_93, 0);
                        break;

                    case 94:
                        score = prefs.getInt(SCORE_LEVEL_6_94, 0);
                        break;

                    case 95:
                        score = prefs.getInt(SCORE_LEVEL_6_95, 0);
                        break;

                    case 96:
                        score = prefs.getInt(SCORE_LEVEL_6_96, 0);
                        break;

                    case 97:
                        score = prefs.getInt(SCORE_LEVEL_6_97, 0);
                        break;

                    case 98:
                        score = prefs.getInt(SCORE_LEVEL_6_98, 0);
                        break;

                    case 99:
                        score = prefs.getInt(SCORE_LEVEL_6_99, 0);
                        break;

                    case 100:
                        score = prefs.getInt(SCORE_LEVEL_6_100, 0);
                        break;

                }
                break;
        }
        return score;
    }

    public static void setLevelPoints(Context context, int schoolGrade, int level, int points) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        switch (schoolGrade) {
            case 1:
                switch (level) {
                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_1_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_1_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_1_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_1_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_1_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_1_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_1_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_1_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_1_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_1_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_1_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_1_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_1_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_1_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_1_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_1_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_1_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_1_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_1_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_1_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_1_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_1_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_1_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_1_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_1_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_1_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_1_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_1_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_1_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_1_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_1_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_1_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_1_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_1_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_1_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_1_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_1_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_1_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_1_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_1_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_1_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_1_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_1_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_1_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_1_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_1_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_1_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_1_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_1_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_1_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_1_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_1_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_1_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_1_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_1_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_1_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_1_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_1_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_1_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_1_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_1_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_1_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_1_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_1_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_1_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_1_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_1_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_1_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_1_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_1_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_1_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_1_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_1_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_1_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_1_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_1_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_1_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_1_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_1_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_1_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_1_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_1_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_1_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_1_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_1_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_1_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_1_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_1_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_1_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_1_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_1_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_1_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_1_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_1_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_1_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_1_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_1_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_1_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_1_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_1_100, points);
                        break;

                }

                break;
            case 2:
                switch (level) {
                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_2_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_2_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_2_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_2_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_2_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_2_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_2_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_2_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_2_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_2_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_2_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_2_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_2_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_2_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_2_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_2_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_2_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_2_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_2_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_2_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_2_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_2_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_2_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_2_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_2_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_2_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_2_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_2_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_2_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_2_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_2_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_2_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_2_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_2_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_2_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_2_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_2_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_2_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_2_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_2_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_2_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_2_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_2_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_2_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_2_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_2_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_2_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_2_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_2_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_2_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_2_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_2_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_2_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_2_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_2_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_2_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_2_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_2_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_2_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_2_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_2_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_2_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_2_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_2_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_2_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_2_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_2_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_2_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_2_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_2_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_2_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_2_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_2_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_2_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_2_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_2_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_2_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_2_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_2_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_2_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_2_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_2_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_2_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_2_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_2_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_2_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_2_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_2_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_2_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_2_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_2_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_2_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_2_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_2_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_2_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_2_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_2_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_2_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_2_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_2_100, points);
                        break;

                }

                break;
            case 3:
                switch (level) {
                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_3_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_3_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_3_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_3_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_3_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_3_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_3_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_3_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_3_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_3_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_3_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_3_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_3_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_3_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_3_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_3_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_3_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_3_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_3_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_3_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_3_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_3_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_3_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_3_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_3_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_3_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_3_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_3_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_3_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_3_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_3_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_3_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_3_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_3_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_3_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_3_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_3_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_3_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_3_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_3_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_3_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_3_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_3_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_3_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_3_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_3_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_3_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_3_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_3_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_3_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_3_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_3_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_3_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_3_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_3_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_3_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_3_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_3_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_3_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_3_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_3_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_3_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_3_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_3_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_3_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_3_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_3_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_3_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_3_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_3_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_3_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_3_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_3_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_3_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_3_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_3_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_3_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_3_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_3_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_3_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_3_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_3_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_3_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_3_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_3_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_3_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_3_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_3_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_3_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_3_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_3_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_3_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_3_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_3_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_3_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_3_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_3_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_3_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_3_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_3_100, points);
                        break;
                }
                break;
            case 4:
                switch (level) {

                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_4_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_4_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_4_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_4_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_4_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_4_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_4_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_4_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_4_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_4_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_4_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_4_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_4_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_4_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_4_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_4_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_4_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_4_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_4_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_4_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_4_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_4_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_4_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_4_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_4_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_4_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_4_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_4_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_4_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_4_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_4_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_4_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_4_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_4_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_4_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_4_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_4_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_4_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_4_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_4_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_4_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_4_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_4_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_4_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_4_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_4_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_4_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_4_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_4_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_4_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_4_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_4_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_4_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_4_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_4_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_4_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_4_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_4_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_4_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_4_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_4_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_4_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_4_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_4_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_4_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_4_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_4_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_4_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_4_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_4_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_4_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_4_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_4_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_4_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_4_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_4_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_4_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_4_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_4_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_4_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_4_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_4_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_4_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_4_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_4_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_4_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_4_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_4_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_4_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_4_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_4_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_4_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_4_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_4_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_4_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_4_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_4_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_4_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_4_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_4_100, points);
                        break;

                }

                break;
            case 5:
                switch (level) {

                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_5_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_5_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_5_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_5_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_5_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_5_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_5_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_5_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_5_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_5_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_5_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_5_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_5_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_5_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_5_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_5_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_5_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_5_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_5_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_5_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_5_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_5_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_5_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_5_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_5_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_5_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_5_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_5_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_5_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_5_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_5_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_5_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_5_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_5_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_5_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_5_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_5_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_5_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_5_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_5_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_5_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_5_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_5_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_5_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_5_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_5_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_5_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_5_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_5_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_5_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_5_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_5_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_5_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_5_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_5_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_5_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_5_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_5_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_5_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_5_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_5_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_5_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_5_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_5_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_5_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_5_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_5_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_5_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_5_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_5_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_5_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_5_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_5_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_5_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_5_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_5_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_5_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_5_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_5_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_5_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_5_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_5_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_5_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_5_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_5_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_5_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_5_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_5_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_5_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_5_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_5_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_5_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_5_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_5_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_5_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_5_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_5_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_5_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_5_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_5_100, points);
                        break;

                }
                break;
            case 6:
                switch (level) {

                    case 1:
                        prefEditor.putInt(POINTS_LEVEL_6_1, points);
                        break;
                    case 2:
                        prefEditor.putInt(POINTS_LEVEL_6_2, points);
                        break;
                    case 3:
                        prefEditor.putInt(POINTS_LEVEL_6_3, points);
                        break;
                    case 4:
                        prefEditor.putInt(POINTS_LEVEL_6_4, points);
                        break;
                    case 5:
                        prefEditor.putInt(POINTS_LEVEL_6_5, points);
                        break;
                    case 6:
                        prefEditor.putInt(POINTS_LEVEL_6_6, points);
                        break;
                    case 7:
                        prefEditor.putInt(POINTS_LEVEL_6_7, points);
                        break;
                    case 8:
                        prefEditor.putInt(POINTS_LEVEL_6_8, points);
                        break;
                    case 9:
                        prefEditor.putInt(POINTS_LEVEL_6_9, points);
                        break;
                    case 10:
                        prefEditor.putInt(POINTS_LEVEL_6_10, points);
                        break;
                    case 11:
                        prefEditor.putInt(POINTS_LEVEL_6_11, points);
                        break;
                    case 12:
                        prefEditor.putInt(POINTS_LEVEL_6_12, points);
                        break;
                    case 13:
                        prefEditor.putInt(POINTS_LEVEL_6_13, points);
                        break;
                    case 14:
                        prefEditor.putInt(POINTS_LEVEL_6_14, points);
                        break;
                    case 15:
                        prefEditor.putInt(POINTS_LEVEL_6_15, points);
                        break;
                    case 16:
                        prefEditor.putInt(POINTS_LEVEL_6_16, points);
                        break;
                    case 17:
                        prefEditor.putInt(POINTS_LEVEL_6_17, points);
                        break;
                    case 18:
                        prefEditor.putInt(POINTS_LEVEL_6_18, points);
                        break;
                    case 19:
                        prefEditor.putInt(POINTS_LEVEL_6_19, points);
                        break;
                    case 20:
                        prefEditor.putInt(POINTS_LEVEL_6_20, points);
                        break;
                    case 21:
                        prefEditor.putInt(POINTS_LEVEL_6_21, points);
                        break;
                    case 22:
                        prefEditor.putInt(POINTS_LEVEL_6_22, points);
                        break;
                    case 23:
                        prefEditor.putInt(POINTS_LEVEL_6_23, points);
                        break;
                    case 24:
                        prefEditor.putInt(POINTS_LEVEL_6_24, points);
                        break;
                    case 25:
                        prefEditor.putInt(POINTS_LEVEL_6_25, points);
                        break;
                    case 26:
                        prefEditor.putInt(POINTS_LEVEL_6_26, points);
                        break;
                    case 27:
                        prefEditor.putInt(POINTS_LEVEL_6_27, points);
                        break;
                    case 28:
                        prefEditor.putInt(POINTS_LEVEL_6_28, points);
                        break;
                    case 29:
                        prefEditor.putInt(POINTS_LEVEL_6_29, points);
                        break;
                    case 30:
                        prefEditor.putInt(POINTS_LEVEL_6_30, points);
                        break;
                    case 31:
                        prefEditor.putInt(POINTS_LEVEL_6_31, points);
                        break;
                    case 32:
                        prefEditor.putInt(POINTS_LEVEL_6_32, points);
                        break;
                    case 33:
                        prefEditor.putInt(POINTS_LEVEL_6_33, points);
                        break;
                    case 34:
                        prefEditor.putInt(POINTS_LEVEL_6_34, points);
                        break;
                    case 35:
                        prefEditor.putInt(POINTS_LEVEL_6_35, points);
                        break;
                    case 36:
                        prefEditor.putInt(POINTS_LEVEL_6_36, points);
                        break;
                    case 37:
                        prefEditor.putInt(POINTS_LEVEL_6_37, points);
                        break;
                    case 38:
                        prefEditor.putInt(POINTS_LEVEL_6_38, points);
                        break;
                    case 39:
                        prefEditor.putInt(POINTS_LEVEL_6_39, points);
                        break;
                    case 40:
                        prefEditor.putInt(POINTS_LEVEL_6_40, points);
                        break;
                    case 41:
                        prefEditor.putInt(POINTS_LEVEL_6_41, points);
                        break;
                    case 42:
                        prefEditor.putInt(POINTS_LEVEL_6_42, points);
                        break;
                    case 43:
                        prefEditor.putInt(POINTS_LEVEL_6_43, points);
                        break;
                    case 44:
                        prefEditor.putInt(POINTS_LEVEL_6_44, points);
                        break;
                    case 45:
                        prefEditor.putInt(POINTS_LEVEL_6_45, points);
                        break;
                    case 46:
                        prefEditor.putInt(POINTS_LEVEL_6_46, points);
                        break;
                    case 47:
                        prefEditor.putInt(POINTS_LEVEL_6_47, points);
                        break;
                    case 48:
                        prefEditor.putInt(POINTS_LEVEL_6_48, points);
                        break;
                    case 49:
                        prefEditor.putInt(POINTS_LEVEL_6_49, points);
                        break;
                    case 50:
                        prefEditor.putInt(POINTS_LEVEL_6_50, points);
                        break;
                    case 51:
                        prefEditor.putInt(POINTS_LEVEL_6_51, points);
                        break;
                    case 52:
                        prefEditor.putInt(POINTS_LEVEL_6_52, points);
                        break;
                    case 53:
                        prefEditor.putInt(POINTS_LEVEL_6_53, points);
                        break;
                    case 54:
                        prefEditor.putInt(POINTS_LEVEL_6_54, points);
                        break;
                    case 55:
                        prefEditor.putInt(POINTS_LEVEL_6_55, points);
                        break;
                    case 56:
                        prefEditor.putInt(POINTS_LEVEL_6_56, points);
                        break;
                    case 57:
                        prefEditor.putInt(POINTS_LEVEL_6_57, points);
                        break;
                    case 58:
                        prefEditor.putInt(POINTS_LEVEL_6_58, points);
                        break;
                    case 59:
                        prefEditor.putInt(POINTS_LEVEL_6_59, points);
                        break;
                    case 60:
                        prefEditor.putInt(POINTS_LEVEL_6_60, points);
                        break;
                    case 61:
                        prefEditor.putInt(POINTS_LEVEL_6_61, points);
                        break;
                    case 62:
                        prefEditor.putInt(POINTS_LEVEL_6_62, points);
                        break;
                    case 63:
                        prefEditor.putInt(POINTS_LEVEL_6_63, points);
                        break;
                    case 64:
                        prefEditor.putInt(POINTS_LEVEL_6_64, points);
                        break;
                    case 65:
                        prefEditor.putInt(POINTS_LEVEL_6_65, points);
                        break;
                    case 66:
                        prefEditor.putInt(POINTS_LEVEL_6_66, points);
                        break;
                    case 67:
                        prefEditor.putInt(POINTS_LEVEL_6_67, points);
                        break;
                    case 68:
                        prefEditor.putInt(POINTS_LEVEL_6_68, points);
                        break;
                    case 69:
                        prefEditor.putInt(POINTS_LEVEL_6_69, points);
                        break;
                    case 70:
                        prefEditor.putInt(POINTS_LEVEL_6_70, points);
                        break;
                    case 71:
                        prefEditor.putInt(POINTS_LEVEL_6_71, points);
                        break;
                    case 72:
                        prefEditor.putInt(POINTS_LEVEL_6_72, points);
                        break;
                    case 73:
                        prefEditor.putInt(POINTS_LEVEL_6_73, points);
                        break;
                    case 74:
                        prefEditor.putInt(POINTS_LEVEL_6_74, points);
                        break;
                    case 75:
                        prefEditor.putInt(POINTS_LEVEL_6_75, points);
                        break;
                    case 76:
                        prefEditor.putInt(POINTS_LEVEL_6_76, points);
                        break;
                    case 77:
                        prefEditor.putInt(POINTS_LEVEL_6_77, points);
                        break;
                    case 78:
                        prefEditor.putInt(POINTS_LEVEL_6_78, points);
                        break;
                    case 79:
                        prefEditor.putInt(POINTS_LEVEL_6_79, points);
                        break;
                    case 80:
                        prefEditor.putInt(POINTS_LEVEL_6_80, points);
                        break;
                    case 81:
                        prefEditor.putInt(POINTS_LEVEL_6_81, points);
                        break;
                    case 82:
                        prefEditor.putInt(POINTS_LEVEL_6_82, points);
                        break;
                    case 83:
                        prefEditor.putInt(POINTS_LEVEL_6_83, points);
                        break;
                    case 84:
                        prefEditor.putInt(POINTS_LEVEL_6_84, points);
                        break;
                    case 85:
                        prefEditor.putInt(POINTS_LEVEL_6_85, points);
                        break;
                    case 86:
                        prefEditor.putInt(POINTS_LEVEL_6_86, points);
                        break;
                    case 87:
                        prefEditor.putInt(POINTS_LEVEL_6_87, points);
                        break;
                    case 88:
                        prefEditor.putInt(POINTS_LEVEL_6_88, points);
                        break;
                    case 89:
                        prefEditor.putInt(POINTS_LEVEL_6_89, points);
                        break;
                    case 90:
                        prefEditor.putInt(POINTS_LEVEL_6_90, points);
                        break;
                    case 91:
                        prefEditor.putInt(POINTS_LEVEL_6_91, points);
                        break;
                    case 92:
                        prefEditor.putInt(POINTS_LEVEL_6_92, points);
                        break;
                    case 93:
                        prefEditor.putInt(POINTS_LEVEL_6_93, points);
                        break;
                    case 94:
                        prefEditor.putInt(POINTS_LEVEL_6_94, points);
                        break;
                    case 95:
                        prefEditor.putInt(POINTS_LEVEL_6_95, points);
                        break;
                    case 96:
                        prefEditor.putInt(POINTS_LEVEL_6_96, points);
                        break;
                    case 97:
                        prefEditor.putInt(POINTS_LEVEL_6_97, points);
                        break;
                    case 98:
                        prefEditor.putInt(POINTS_LEVEL_6_98, points);
                        break;
                    case 99:
                        prefEditor.putInt(POINTS_LEVEL_6_99, points);
                        break;
                    case 100:
                        prefEditor.putInt(POINTS_LEVEL_6_100, points);
                        break;
                }

        }
        prefEditor.apply();
    }


    public static int getLevelPoints(Context context, int schoolGrade, int level) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        int points = 0;
        switch (schoolGrade) {
            case 1:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_1_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_1_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_1_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_1_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_1_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_1_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_1_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_1_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_1_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_1_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_1_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_1_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_1_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_1_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_1_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_1_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_1_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_1_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_1_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_1_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_1_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_1_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_1_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_1_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_1_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_1_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_1_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_1_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_1_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_1_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_1_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_1_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_1_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_1_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_1_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_1_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_1_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_1_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_1_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_1_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_1_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_1_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_1_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_1_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_1_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_1_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_1_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_1_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_1_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_1_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_1_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_1_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_1_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_1_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_1_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_1_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_1_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_1_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_1_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_1_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_1_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_1_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_1_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_1_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_1_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_1_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_1_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_1_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_1_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_1_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_1_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_1_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_1_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_1_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_1_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_1_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_1_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_1_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_1_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_1_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_1_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_1_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_1_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_1_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_1_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_1_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_1_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_1_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_1_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_1_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_1_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_1_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_1_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_1_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_1_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_1_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_1_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_1_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_1_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_1_100, 0);
                        break;

                }
                break;
            case 2:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_2_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_2_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_2_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_2_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_2_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_2_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_2_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_2_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_2_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_2_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_2_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_2_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_2_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_2_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_2_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_2_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_2_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_2_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_2_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_2_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_2_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_2_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_2_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_2_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_2_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_2_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_2_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_2_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_2_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_2_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_2_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_2_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_2_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_2_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_2_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_2_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_2_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_2_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_2_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_2_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_2_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_2_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_2_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_2_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_2_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_2_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_2_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_2_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_2_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_2_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_2_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_2_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_2_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_2_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_2_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_2_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_2_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_2_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_2_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_2_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_2_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_2_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_2_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_2_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_2_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_2_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_2_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_2_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_2_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_2_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_2_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_2_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_2_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_2_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_2_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_2_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_2_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_2_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_2_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_2_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_2_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_2_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_2_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_2_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_2_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_2_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_2_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_2_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_2_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_2_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_2_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_2_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_2_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_2_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_2_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_2_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_2_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_2_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_2_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_2_100, 0);
                        break;

                }
                break;
            case 3:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_3_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_3_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_3_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_3_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_3_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_3_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_3_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_3_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_3_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_3_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_3_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_3_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_3_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_3_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_3_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_3_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_3_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_3_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_3_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_3_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_3_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_3_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_3_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_3_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_3_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_3_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_3_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_3_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_3_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_3_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_3_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_3_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_3_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_3_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_3_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_3_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_3_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_3_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_3_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_3_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_3_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_3_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_3_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_3_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_3_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_3_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_3_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_3_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_3_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_3_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_3_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_3_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_3_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_3_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_3_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_3_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_3_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_3_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_3_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_3_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_3_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_3_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_3_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_3_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_3_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_3_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_3_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_3_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_3_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_3_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_3_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_3_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_3_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_3_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_3_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_3_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_3_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_3_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_3_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_3_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_3_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_3_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_3_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_3_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_3_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_3_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_3_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_3_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_3_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_3_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_3_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_3_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_3_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_3_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_3_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_3_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_3_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_3_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_3_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_3_100, 0);
                        break;

                }
                break;
            case 4:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_4_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_4_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_4_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_4_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_4_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_4_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_4_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_4_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_4_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_4_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_4_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_4_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_4_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_4_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_4_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_4_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_4_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_4_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_4_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_4_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_4_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_4_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_4_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_4_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_4_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_4_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_4_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_4_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_4_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_4_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_4_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_4_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_4_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_4_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_4_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_4_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_4_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_4_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_4_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_4_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_4_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_4_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_4_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_4_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_4_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_4_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_4_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_4_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_4_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_4_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_4_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_4_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_4_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_4_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_4_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_4_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_4_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_4_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_4_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_4_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_4_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_4_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_4_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_4_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_4_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_4_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_4_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_4_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_4_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_4_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_4_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_4_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_4_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_4_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_4_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_4_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_4_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_4_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_4_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_4_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_4_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_4_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_4_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_4_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_4_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_4_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_4_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_4_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_4_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_4_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_4_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_4_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_4_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_4_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_4_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_4_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_4_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_4_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_4_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_4_100, 0);
                        break;

                }
                break;
            case 5:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_5_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_5_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_5_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_5_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_5_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_5_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_5_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_5_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_5_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_5_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_5_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_5_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_5_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_5_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_5_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_5_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_5_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_5_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_5_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_5_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_5_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_5_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_5_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_5_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_5_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_5_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_5_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_5_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_5_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_5_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_5_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_5_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_5_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_5_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_5_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_5_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_5_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_5_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_5_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_5_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_5_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_5_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_5_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_5_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_5_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_5_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_5_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_5_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_5_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_5_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_5_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_5_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_5_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_5_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_5_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_5_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_5_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_5_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_5_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_5_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_5_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_5_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_5_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_5_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_5_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_5_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_5_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_5_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_5_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_5_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_5_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_5_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_5_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_5_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_5_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_5_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_5_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_5_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_5_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_5_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_5_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_5_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_5_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_5_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_5_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_5_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_5_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_5_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_5_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_5_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_5_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_5_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_5_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_5_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_5_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_5_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_5_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_5_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_5_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_5_100, 0);
                        break;

                }
                break;
            case 6:
                switch (level) {
                    case 1:
                        points = prefs.getInt(POINTS_LEVEL_6_1, 0);
                        break;
                    case 2:
                        points = prefs.getInt(POINTS_LEVEL_6_2, 0);
                        break;
                    case 3:
                        points = prefs.getInt(POINTS_LEVEL_6_3, 0);
                        break;
                    case 4:
                        points = prefs.getInt(POINTS_LEVEL_6_4, 0);
                        break;
                    case 5:
                        points = prefs.getInt(POINTS_LEVEL_6_5, 0);
                        break;
                    case 6:
                        points = prefs.getInt(POINTS_LEVEL_6_6, 0);
                        break;
                    case 7:
                        points = prefs.getInt(POINTS_LEVEL_6_7, 0);
                        break;
                    case 8:
                        points = prefs.getInt(POINTS_LEVEL_6_8, 0);
                        break;
                    case 9:
                        points = prefs.getInt(POINTS_LEVEL_6_9, 0);
                        break;
                    case 10:
                        points = prefs.getInt(POINTS_LEVEL_6_10, 0);
                        break;

                    case 11:
                        points = prefs.getInt(POINTS_LEVEL_6_11, 0);
                        break;

                    case 12:
                        points = prefs.getInt(POINTS_LEVEL_6_12, 0);
                        break;

                    case 13:
                        points = prefs.getInt(POINTS_LEVEL_6_13, 0);
                        break;

                    case 14:
                        points = prefs.getInt(POINTS_LEVEL_6_14, 0);
                        break;

                    case 15:
                        points = prefs.getInt(POINTS_LEVEL_6_15, 0);
                        break;

                    case 16:
                        points = prefs.getInt(POINTS_LEVEL_6_16, 0);
                        break;

                    case 17:
                        points = prefs.getInt(POINTS_LEVEL_6_17, 0);
                        break;

                    case 18:
                        points = prefs.getInt(POINTS_LEVEL_6_18, 0);
                        break;

                    case 19:
                        points = prefs.getInt(POINTS_LEVEL_6_19, 0);
                        break;

                    case 20:
                        points = prefs.getInt(POINTS_LEVEL_6_20, 0);
                        break;

                    case 21:
                        points = prefs.getInt(POINTS_LEVEL_6_21, 0);
                        break;

                    case 22:
                        points = prefs.getInt(POINTS_LEVEL_6_22, 0);
                        break;

                    case 23:
                        points = prefs.getInt(POINTS_LEVEL_6_23, 0);
                        break;

                    case 24:
                        points = prefs.getInt(POINTS_LEVEL_6_24, 0);
                        break;

                    case 25:
                        points = prefs.getInt(POINTS_LEVEL_6_25, 0);
                        break;

                    case 26:
                        points = prefs.getInt(POINTS_LEVEL_6_26, 0);
                        break;

                    case 27:
                        points = prefs.getInt(POINTS_LEVEL_6_27, 0);
                        break;

                    case 28:
                        points = prefs.getInt(POINTS_LEVEL_6_28, 0);
                        break;

                    case 29:
                        points = prefs.getInt(POINTS_LEVEL_6_29, 0);
                        break;

                    case 30:
                        points = prefs.getInt(POINTS_LEVEL_6_30, 0);
                        break;

                    case 31:
                        points = prefs.getInt(POINTS_LEVEL_6_31, 0);
                        break;

                    case 32:
                        points = prefs.getInt(POINTS_LEVEL_6_32, 0);
                        break;

                    case 33:
                        points = prefs.getInt(POINTS_LEVEL_6_33, 0);
                        break;

                    case 34:
                        points = prefs.getInt(POINTS_LEVEL_6_34, 0);
                        break;

                    case 35:
                        points = prefs.getInt(POINTS_LEVEL_6_35, 0);
                        break;

                    case 36:
                        points = prefs.getInt(POINTS_LEVEL_6_36, 0);
                        break;

                    case 37:
                        points = prefs.getInt(POINTS_LEVEL_6_37, 0);
                        break;

                    case 38:
                        points = prefs.getInt(POINTS_LEVEL_6_38, 0);
                        break;

                    case 39:
                        points = prefs.getInt(POINTS_LEVEL_6_39, 0);
                        break;

                    case 40:
                        points = prefs.getInt(POINTS_LEVEL_6_40, 0);
                        break;

                    case 41:
                        points = prefs.getInt(POINTS_LEVEL_6_41, 0);
                        break;

                    case 42:
                        points = prefs.getInt(POINTS_LEVEL_6_42, 0);
                        break;

                    case 43:
                        points = prefs.getInt(POINTS_LEVEL_6_43, 0);
                        break;

                    case 44:
                        points = prefs.getInt(POINTS_LEVEL_6_44, 0);
                        break;

                    case 45:
                        points = prefs.getInt(POINTS_LEVEL_6_45, 0);
                        break;

                    case 46:
                        points = prefs.getInt(POINTS_LEVEL_6_46, 0);
                        break;

                    case 47:
                        points = prefs.getInt(POINTS_LEVEL_6_47, 0);
                        break;

                    case 48:
                        points = prefs.getInt(POINTS_LEVEL_6_48, 0);
                        break;

                    case 49:
                        points = prefs.getInt(POINTS_LEVEL_6_49, 0);
                        break;

                    case 50:
                        points = prefs.getInt(POINTS_LEVEL_6_50, 0);
                        break;

                    case 51:
                        points = prefs.getInt(POINTS_LEVEL_6_51, 0);
                        break;

                    case 52:
                        points = prefs.getInt(POINTS_LEVEL_6_52, 0);
                        break;

                    case 53:
                        points = prefs.getInt(POINTS_LEVEL_6_53, 0);
                        break;

                    case 54:
                        points = prefs.getInt(POINTS_LEVEL_6_54, 0);
                        break;

                    case 55:
                        points = prefs.getInt(POINTS_LEVEL_6_55, 0);
                        break;

                    case 56:
                        points = prefs.getInt(POINTS_LEVEL_6_56, 0);
                        break;

                    case 57:
                        points = prefs.getInt(POINTS_LEVEL_6_57, 0);
                        break;

                    case 58:
                        points = prefs.getInt(POINTS_LEVEL_6_58, 0);
                        break;

                    case 59:
                        points = prefs.getInt(POINTS_LEVEL_6_59, 0);
                        break;

                    case 60:
                        points = prefs.getInt(POINTS_LEVEL_6_60, 0);
                        break;

                    case 61:
                        points = prefs.getInt(POINTS_LEVEL_6_61, 0);
                        break;

                    case 62:
                        points = prefs.getInt(POINTS_LEVEL_6_62, 0);
                        break;

                    case 63:
                        points = prefs.getInt(POINTS_LEVEL_6_63, 0);
                        break;

                    case 64:
                        points = prefs.getInt(POINTS_LEVEL_6_64, 0);
                        break;

                    case 65:
                        points = prefs.getInt(POINTS_LEVEL_6_65, 0);
                        break;

                    case 66:
                        points = prefs.getInt(POINTS_LEVEL_6_66, 0);
                        break;

                    case 67:
                        points = prefs.getInt(POINTS_LEVEL_6_67, 0);
                        break;

                    case 68:
                        points = prefs.getInt(POINTS_LEVEL_6_68, 0);
                        break;

                    case 69:
                        points = prefs.getInt(POINTS_LEVEL_6_69, 0);
                        break;

                    case 70:
                        points = prefs.getInt(POINTS_LEVEL_6_70, 0);
                        break;

                    case 71:
                        points = prefs.getInt(POINTS_LEVEL_6_71, 0);
                        break;

                    case 72:
                        points = prefs.getInt(POINTS_LEVEL_6_72, 0);
                        break;

                    case 73:
                        points = prefs.getInt(POINTS_LEVEL_6_73, 0);
                        break;

                    case 74:
                        points = prefs.getInt(POINTS_LEVEL_6_74, 0);
                        break;

                    case 75:
                        points = prefs.getInt(POINTS_LEVEL_6_75, 0);
                        break;

                    case 76:
                        points = prefs.getInt(POINTS_LEVEL_6_76, 0);
                        break;

                    case 77:
                        points = prefs.getInt(POINTS_LEVEL_6_77, 0);
                        break;

                    case 78:
                        points = prefs.getInt(POINTS_LEVEL_6_78, 0);
                        break;

                    case 79:
                        points = prefs.getInt(POINTS_LEVEL_6_79, 0);
                        break;

                    case 80:
                        points = prefs.getInt(POINTS_LEVEL_6_80, 0);
                        break;

                    case 81:
                        points = prefs.getInt(POINTS_LEVEL_6_81, 0);
                        break;

                    case 82:
                        points = prefs.getInt(POINTS_LEVEL_6_82, 0);
                        break;

                    case 83:
                        points = prefs.getInt(POINTS_LEVEL_6_83, 0);
                        break;

                    case 84:
                        points = prefs.getInt(POINTS_LEVEL_6_84, 0);
                        break;

                    case 85:
                        points = prefs.getInt(POINTS_LEVEL_6_85, 0);
                        break;

                    case 86:
                        points = prefs.getInt(POINTS_LEVEL_6_86, 0);
                        break;

                    case 87:
                        points = prefs.getInt(POINTS_LEVEL_6_87, 0);
                        break;

                    case 88:
                        points = prefs.getInt(POINTS_LEVEL_6_88, 0);
                        break;

                    case 89:
                        points = prefs.getInt(POINTS_LEVEL_6_89, 0);
                        break;

                    case 90:
                        points = prefs.getInt(POINTS_LEVEL_6_90, 0);
                        break;

                    case 91:
                        points = prefs.getInt(POINTS_LEVEL_6_91, 0);
                        break;

                    case 92:
                        points = prefs.getInt(POINTS_LEVEL_6_92, 0);
                        break;

                    case 93:
                        points = prefs.getInt(POINTS_LEVEL_6_93, 0);
                        break;

                    case 94:
                        points = prefs.getInt(POINTS_LEVEL_6_94, 0);
                        break;

                    case 95:
                        points = prefs.getInt(POINTS_LEVEL_6_95, 0);
                        break;

                    case 96:
                        points = prefs.getInt(POINTS_LEVEL_6_96, 0);
                        break;

                    case 97:
                        points = prefs.getInt(POINTS_LEVEL_6_97, 0);
                        break;

                    case 98:
                        points = prefs.getInt(POINTS_LEVEL_6_98, 0);
                        break;

                    case 99:
                        points = prefs.getInt(POINTS_LEVEL_6_99, 0);
                        break;

                    case 100:
                        points = prefs.getInt(POINTS_LEVEL_6_100, 0);
                        break;

                }
                break;
        }
        return points;

    }

    public static void setTimeRecord(Context context, String record, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        switch (schoolGrade) {
            case 1:
                prefEditor.putString(TIME_RECORD_1, record);
                break;
            case 2:
                prefEditor.putString(TIME_RECORD_2, record);
                break;
            case 3:
                prefEditor.putString(TIME_RECORD_3, record);
                break;
            case 4:
                prefEditor.putString(TIME_RECORD_4, record);
                break;
            case 5:
                prefEditor.putString(TIME_RECORD_5, record);
                break;
            case 6:
                prefEditor.putString(TIME_RECORD_6, record);
                break;
        }
        prefEditor.apply();
    }

    public static String getTimeRecord(Context context, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        String level = "0:00.0";
        switch (schoolGrade) {
            case 1:
                level = prefs.getString(TIME_RECORD_1, "0:00.0");
                break;
            case 2:
                level = prefs.getString(TIME_RECORD_2, "0:00.0");
                break;
            case 3:
                level = prefs.getString(TIME_RECORD_3, "0:00.0");
                break;
            case 4:
                level = prefs.getString(TIME_RECORD_4, "0:00.0");
                break;
            case 5:
                level = prefs.getString(TIME_RECORD_5, "0:00.0");
                break;
            case 6:
                level = prefs.getString(TIME_RECORD_6, "0:00.0");
                break;
        }
        return level;

    }

    public static void setQuestionRecord(Context context, int record, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        switch (schoolGrade) {
            case 1:
                prefEditor.putInt(QUESTION_RECORD_1, record);
                break;
            case 2:
                prefEditor.putInt(QUESTION_RECORD_2, record);
                break;
            case 3:
                prefEditor.putInt(QUESTION_RECORD_3, record);
                break;
            case 4:
                prefEditor.putInt(QUESTION_RECORD_4, record);
                break;
            case 5:
                prefEditor.putInt(QUESTION_RECORD_5, record);
                break;
            case 6:
                prefEditor.putInt(QUESTION_RECORD_6, record);
                break;
        }
        prefEditor.apply();
    }

    public static int getQuestionRecord(Context context, int schoolGrade) {
        SharedPreferences prefs = context.getSharedPreferences(SETTING_Quiz_PREF, Context.MODE_PRIVATE);
        int level = 0;
        switch (schoolGrade) {
            case 1:
                level = prefs.getInt(QUESTION_RECORD_1, 0);
                break;
            case 2:
                level = prefs.getInt(QUESTION_RECORD_2, 0);
                break;
            case 3:
                level = prefs.getInt(QUESTION_RECORD_3, 0);
                break;
            case 4:
                level = prefs.getInt(QUESTION_RECORD_4, 0);
                break;
            case 5:
                level = prefs.getInt(QUESTION_RECORD_5, 0);
                break;
            case 6:
                level = prefs.getInt(QUESTION_RECORD_6, 0);
                break;
        }
        return level;

    }


}
