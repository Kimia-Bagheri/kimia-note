package com.kimia.bulletjournal
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AddNoteActivity : AppCompatActivity() {

    private lateinit var noteTitleEditText: EditText
    private lateinit var noteContentEditText: EditText
    private lateinit var saveNoteButton: Button
    private lateinit var firestore: FirebaseFirestore
    private lateinit var mAuth: FirebaseAuth

    private var position: Int = -1
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        noteTitleEditText = findViewById(R.id.noteTitleEditText)
        noteContentEditText = findViewById(R.id.noteContentEditText)
        saveNoteButton = findViewById(R.id.saveNoteButton)

        firestore = FirebaseFirestore.getInstance()
        mAuth = FirebaseAuth.getInstance()

        note = intent.getParcelableExtra("note")
        if (note != null) {
            noteTitleEditText.setText(note!!.title)
            noteContentEditText.setText(note!!.content)
            position = intent.getIntExtra("position", -1)
        }

        saveNoteButton.setOnClickListener {
            val title = noteTitleEditText.text.toString().trim()
            val content = noteContentEditText.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save note logic here
            val note = Note(title, content)
            val resultIntent = Intent().apply {
                putExtra("note", note)
                putExtra("position", position)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
