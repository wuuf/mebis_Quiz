package de.carpelibrum.quiz;

import de.carpelibrum.quiz.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends Activity implements android.view.View.OnClickListener {
	Spiellogik spiel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		// Spiellogik instanziieren
		spiel = new Spiellogik();
		
		// Antwort-Buttons mit Ereignislistener verbinden
		for (int n = 1; n <= 4; n++) {
			Button btn = null;

			switch (n) {
			case 1:
				btn = (Button) this.findViewById(id.antwort1);
				btn.setOnClickListener(this); 
				break;
			case 2:
				btn = (Button) this.findViewById(id.antwort2);
				btn.setOnClickListener(this);
				break;
			case 3:
				btn = (Button) this.findViewById(id.antwort3);
				btn.setOnClickListener(this); 
				break;
			case 4:
				btn = (Button) this.findViewById(id.antwort4);
				btn.setOnClickListener(this); 
				break;
			}

		}

		// 1. Frage laden
		spiel.fragen[spiel.aktFrage].anzeigen(this);
	}

	public void onClick(View v) {
		int id = v.getId();

		if (id == R.id.antwort1)
			spiel.auswerten(1, this); // spielAuswerten(1);
		else if (id == R.id.antwort2)
			spiel.auswerten(2, this); // spielAuswerten(2);
		else if (id == R.id.antwort3)
			spiel.auswerten(3, this); // spielAuswerten(3);
		else if (id == R.id.antwort4)
			spiel.auswerten(4, this); // spielAuswerten(4);
	}
	
}