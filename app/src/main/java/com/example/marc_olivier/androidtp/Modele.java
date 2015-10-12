package pratsm.iut.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;

import com.example.marc_olivier.androidtp.R;

public class Modele {
       public Modele() {
                tablettes = getResources().getStringArray(R.array.tablets);/*
 Ci-dessous le code permettant d'initialiser le tableau tablettes � partir du nombre de tablettes et du pr�fixe suppos�s
existant dans les r�f�rences. */

 SharedPreferences mySP = getSharedPreferences(MY_PREFS, Activity.MODE_PRIVATE) ;
 int nbTablettes = mySP.getInt(NB_TABS, NB_TABS_DEF) ;
 String radTab = mySP.getString(RAD_TABS, RAD_TABS_DEF) ;
 tablettes = new String[nbTablettes] ;
 for (int i = 1 ; i <= nbTablettes ; i++) {
 tablettes[i] = radTab + i;
 }

// RAZ tableau students.
               students = new int[tablettes.length];
                for (int i = 0; i < students.length; i++) {
                        students[i] = 0;
                }
        }

  /* Reconstruction � partir d'un bundle */
        public Modele(Bundle inState) {
                tablettes = getResources().getStringArray(R.array.tablets);
                students = inState.getIntArray("students");
        }

        /* Sauvegarde vers un Bundle */
        public void save(Bundle outState) {
                outState.putIntArray("students", students);
        }
/* Fonction d'acc�s aux donn�es */

        /**
         * GetCount: retourne le nombre de tablettes.
         */
        public int getCount() {
                return tablettes.length;
        }

}