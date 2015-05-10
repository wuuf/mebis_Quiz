package de.carpelibrum.quiz;

import de.carpelibrum.quiz.R.id;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;


class Frage {
   private String frage;
   private String option1;
   private String option2;
   private String option3;
   private String option4;
   private int loesung;

   public Frage(String f, String o1, String o2, String o3, String o4, int l) {
      frage = f;
      option1 = o1;
      option2 = o2;
      option3 = o3;
      option4 = o4;
      loesung = l;
   }

   public void anzeigen(Activity quizActivity) {
	   	((TextView) quizActivity.findViewById(id.frage)).setText(frage);
	   	((Button) quizActivity.findViewById(id.antwort1)).setText(option1);
	   	((Button) quizActivity.findViewById(id.antwort2)).setText(option2);
	   	((Button) quizActivity.findViewById(id.antwort3)).setText(option3);
	   	((Button) quizActivity.findViewById(id.antwort4)).setText(option4);     
   }

   public boolean richtig(int ausgewaehlt) {
      if (ausgewaehlt == this.loesung)
         return true;
      else
         return false;
   }
}

