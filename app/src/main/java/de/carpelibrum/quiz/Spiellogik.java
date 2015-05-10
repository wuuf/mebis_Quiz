package de.carpelibrum.quiz;

import de.carpelibrum.quiz.R.id;
import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


class Spiellogik {
   final int ANZAHL_FRAGEN = 8;

   Frage[] fragen = new Frage[ANZAHL_FRAGEN];
   byte aktFrage = 0;
   int gewinnstufe = 0;

   Spiellogik() {
      // Fragen erzeugen
	   
	  /********  Disney  *********/
      fragen[0] = new Frage("Wir sind mit Arbeitspaketen komplett zu",
                            "Böttcher", "Birner", "Czaputa", "Vitz", 3);
      fragen[1] = new Frage("Leider hat ein gewisser Herr ihn wieder unter seinen Fittichen!",
                            "Böttcher", "Birner", "Czaputa", "Duggen", 4);
      fragen[2] = new Frage("Wir sollten standardmäßig auf default stellen.",
                            "Scherl", "Birner", "Czaputa", "Duggen", 1);
      fragen[3] = new Frage("Das System muss so flexibel sein, dass es für andere Anwendungen nutzbar wird.",
                            "Scherl", "Birner", "Graf", "Ruppert", 3);
      fragen[4] = new Frage("Das sind nicht meine MiBs!",
                            "Scherl", "Birner", "Graf", "Ruppert", 4);
      fragen[5] = new Frage("Das wird beim Datenschutz so nie durchgehen ... oder auch schon!",
                            "Böttcher", "Birner", "Czaputa", "Vitz", 4);
      fragen[6] = new Frage("Die Markterkundung zeigte: Es gibt keinen Markt!",
                            "Duggen", "Birner", "Czaputa", "Vitz", 2);
      fragen[7] = new Frage("Na gut! Dann übernheme ich die MIBs!",
                            "Scherl", "Birner", "Graf", "Ruppert", 4);
	   
   }

   void auswerten(int schalter, Activity quizActivity) {

      if (!fragen[aktFrage].richtig(schalter)) {  // falsch beantwortet
         if (gewinnstufe == 0) {
        	 Toast.makeText(quizActivity, "Leider nichts gewonnen.  :-(", Toast.LENGTH_LONG).show();
         }
         else {
     	 	String str = "Du hast Gewinnstufe " + gewinnstufe + " erreicht!  :-)  - Glückwunsch. Mach so weiter, und du bist bald im ISB!!!";
    	 	Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();
         }
         // Schalter deaktivieren
         ((Button) quizActivity.findViewById(id.antwort1)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort2)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort3)).setEnabled(false);
         ((Button) quizActivity.findViewById(id.antwort4)).setEnabled(false);

      } else {
    	 if (aktFrage < ANZAHL_FRAGEN-1) {
            fragen[++aktFrage].anzeigen(quizActivity);

            gewinnstufe++;
            ((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(gewinnstufe);
         }
      	 else {
      		gewinnstufe++;
      		((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(gewinnstufe);
             
      		String str = "Super! Du kennst die mebis-Interna und kannst in der Projektgruppe mitreden!!!";
      		Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();

      		// Schalter deaktivieren
      		((Button) quizActivity.findViewById(id.antwort1)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort2)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort3)).setEnabled(false);
      		((Button) quizActivity.findViewById(id.antwort4)).setEnabled(false);
      	 }
      }
   }
}