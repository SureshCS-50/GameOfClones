package com.sureshCS50.gameofclones.utils;

import com.sureshCS50.gameofclones.R;

public class Constants {

    public static final String ct_arc = "Advanced Recon Commandos";
    public static final String ct_scuba = "Clone SCUBA troopers";
    public static final String ct_shooter = "Clone sharpshooters";
    public static final String ct_jetpack = "Clone jetpack troopers";
    public static final String ct_specialist = "Clone ordnance specialists";
    public static final String bd_b1 = "B1 Battle droids";
    public static final String bd_b2 = "B2 Super battle droids";
    public static final String bd_aat = "Armored Assault Tanks";

    public static final String ct = "Clone Troopers";
    public static final String bd = "Battle Droids";

    public static int getImageResource(String name){
        switch(name){
            case ct_arc:
                return R.drawable.clone_commandos;
            case ct_jetpack:
                return R.drawable.clone_jetpack;
            case ct_scuba:
                return R.drawable.clone_scuba_trooper;
            case ct_shooter:
                return R.drawable.clone_sharp_shooter;
            case ct_specialist:
                return R.drawable.clone_ordnance_specialist;
            case bd_b1:
                return R.drawable.battle_droid_b1;
            case bd_b2:
                return R.drawable.battle_droid_b2;
            case bd_aat:
                return R.drawable.battle_droid_aat;
                default:
                    return R.drawable.clone_troops;
        }
    }

}
