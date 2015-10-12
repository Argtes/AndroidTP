package pratsm.iut.myapplication2.app;

import android.app.Activity;
import android.content.SharedPreferences;
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
		
		/**
* getStudent: Retourne le numéroi de l'étudiant associé à une tablette.
* (0 si pas d'étudiant -> tablette disponible)
* @param position Le numéro de la tablette visée (de 0 à ... )
* @return le numéro de l'étudiant associé.
*/
public int getStudent(int position) {
return students[position] ;
}
/**
* getTerminal: Calcule le nom d'une tablette.
* @param position: le numéro de la tablette (0 à ...)
* @return Le nom courant de la tablette.
*/
public String getTerminal(int position) {
if (position < 0) return null ;
if (position >= tablettes.length) return null ;
return tablettes[position] ;
}
/**
* setStudent: Affecte un étudiant (spcifié par son numéro) à une tablette (spécifiée par son index).
* Permet également de rendre disponioble une tablette (si student = 0).
* Retourne faux en cas d'érreur:
* - Si l'étudiant a déjà une autre tablette affectée.
* - Si Si le numéro d'étudiant n'est pas valide (entre 0 et nbEtudiants).
* @param position
* @param student
* @return Vrai si ok, faux sinon.
*/
public boolean setStudent(int position, int student) {
if (student != 0) {
for (int i = 0 ; i < students.length ; i++) {
if ((i != position) &&(students[i] == student)) return false ;
}
}
students[position] = student ;
return true ;
}
}

}