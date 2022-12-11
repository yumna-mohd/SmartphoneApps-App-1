package com.example.calculatorappa2

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_screen.*


class MainActivity : AppCompatActivity() {

    //declaring the two array "genre" for the drop-down genre options and "lang" for the drop-down language options
    val genre = arrayOf("Hip Hop (default)", "Jazz", "Folk", "Rock")
    val lang = arrayOf("English (default)", "Arabic", "hindi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //hiding the title bar
        supportActionBar?.hide() //hiding the title bar
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        //using the array-adapters and making it view simply with spinners
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,genre)
        val arrayAdapter2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lang)

        //spinner 1
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //the following toast appears when an item is selected
                Toast.makeText(applicationContext, "Currently selected genre is: "+genre[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        //spinner 2
        spinner2.adapter = arrayAdapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //the following toast appears when an item is selected
                Toast.makeText(applicationContext, "Currently selected language is: "+lang[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        //suggest button
        button.setOnClickListener {
            //setting a dialog with with the title "we suggest you" once the "suggest" button is clicked
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setIcon(R.mipmap.ic_launcher_round) //set alertdialog icon
            mAlertDialog.setTitle("we Suggest You: ") //set alertdialog title

            //using "when" expression instead of cascade if statement to shorted the code lines
            when (spinner2.selectedItemPosition) {
                0 ->  when (spinner.selectedItemPosition) {
                    0 -> mAlertDialog.setMessage("1. “Lose Yourself” – Eminem\n2. “Bodak Yellow” – Cardi B\n3. “Ms. Jackson” – Outcast\n4. “Dear Mama” – 2Pac\n5. “Lost Ones” – Lauryn Hill\n6. “Fight The Power” – Public Enemy\n7. “Juicy” – Notorious B.I.G.\n8. “Me Myself And I” – De La Soul\n9. “99 Problems” – Jay Z")
                    1 -> mAlertDialog.setMessage("1. Summertime – Ella Fitzgerald & Louis Armstrong\n2. I Got Rhythm – Sarah Vaughan\n3. Body and Soul – Coleman Hawkins\n4. The Girl From Ipanema – Stan Getz\n5. Round Midnight – Thelonious Monk\n6.  Georgia On My Mind – Billie Holiday\n7. Autumn Leaves – Cannonball Adderley\n8. Straight, No Chaser – Miles Davis\n9. All The Things You Are – Bill Evans")
                    2 -> mAlertDialog.setMessage("1. John Barleycorn – Mat Williams\n2. Rounding the Horn – A.L Lloyd\n3. Bonny Udny – Iona Fyfe\n4. The Girl From Ipanema – Stan Getz\n5. The Derby Ram – Mat Williams\n6.  Adieu,Adieu(The Flash Lad) – The Watersons\n7. Ye Mar'ners All – A.L.Lloyd\n8. John Peel – Mat Williams")
                    3 -> mAlertDialog.setMessage("1. Closer – The Chainsmokers\n2. Rockabye – Clean Bandit\n3. Mirrors – JT\n4. Sultan of Swing – Dire Straits\n5. Those Days – Nickelback\n6.  The Walk Home – Young the Giant\n7. Substance – Demi Lovato")
                }

                1 -> when (spinner.selectedItemPosition) {
                    0 -> mAlertDialog.setMessage("1. Lawla – The Synaptik\n2. Nadi Canadi – Tagne\n3. Aicha la vie – Didine Canon\n4. Nsitou Linseni – Samara\n5. Soukara – JenJoon\n6.  Calma – Master Sina\n7. Ya Wa3dy – E.Evil")
                    1 -> mAlertDialog.setMessage("1. Nomada Slang – Ibrahim Maalouf\n2. Abou Afif – Ahmad Kaabour\n3. Leaving Adana – Hijaz\n4. Masar – Le Trio Joubran\n5. Hems – Hijaz\n6.  Me. J.P.S. – Hijaz")
                    2 -> mAlertDialog.setMessage("1. Ragnarok – Leaves' Eyes\n2. Esoteric Agenda – The HAARP Machine\n3. Inni Mnih – Mashrou' Lella\n4. Amessa – Souad Massi\n5. Annil – Oum Kalthoum")
                    3 -> mAlertDialog.setMessage("1. Asheek – El Morabba3\n2. Ala Ramshe – Khalas\n3. Min Shaf Habibi – JadaL\n4. Alf Leila– Khalas\n5. Fasateen – Mashrou' Leila\n6. Hebbina - Khalas")
                }

                2->   when (spinner.selectedItemPosition) {
                    0 -> mAlertDialog.setMessage("1. Apna Time Aayega – Gully Boy\n2. Shor Machega – Mumbai Saga\n3. Aazadi – Gully Boy\n4. Bornfire – Gunehgar\n5. Mai Wahi Hoon – Mr.Nasir")
                    1 -> mAlertDialog.setMessage("1. Aise Na Dekho – A.r Rehman\n2. Rehna Tu – Karthik\n3. Taarefon Se – Amit Trivedi\n4. Behka – Karthik\n5. Dil ko Hazar Bar – Alsiha Chinai\n6. Mehki Mehki – Kshitij Wagh")
                    2 -> mAlertDialog.setMessage("1. Ghoomar – Shreya Ghoshal\n2. Genda Phool – Rekha Bhardwaj\n3. Ambarsariya – Sona Mohapatra\n4. Bumbro– Shankar Magadevan\n5. Banno – Brijesh Shandilya")
                    3 -> mAlertDialog.setMessage("1. Rock On!! – Farhan Akhtar\n2. Saada Haq – Mohit Chauhan\n3. Naav – Mohan\n4. Socha Hai – Farhan Akhtar\n5. Jee Karda – Divya Kumar")
                }
            }

            //adding a close button to the  pop up alert box
            mAlertDialog.setPositiveButton("Close") { dialog, id ->
                //the following toast appears when the "close" button is clicked
                Toast.makeText(this@MainActivity, "Closed List", Toast.LENGTH_SHORT).show()
            }

            //displaying the alert box by referring it to the "rounded_shape" activity that curves the borders of the alert box
            mAlertDialog.show()
                .window?.setBackgroundDrawableResource(R.drawable.rounded_shape)
        }

        //the following alert box appears when the image-button for instructions is clicked
        imageButton9.setOnClickListener{
            val mAlertDialog2 = AlertDialog.Builder(this@MainActivity)
            mAlertDialog2.setIcon(R.mipmap.ic_launcher_round) //set alertdialog icon
            mAlertDialog2.setTitle("Instructions: ") //setting the title
            mAlertDialog2.setMessage("\nStep 1: Select your preferred genre\nStep 2: Select your preferred language\nStep 3: Click the suggest button\n\nWe will suggest you a list of songs based on your preferences")
           //adding a closing button
            mAlertDialog2.setPositiveButton("Close") { dialog, id ->
            }

            //displaying the alert box
            mAlertDialog2.show()
                .window?.setBackgroundDrawableResource(R.drawable.rounded_shape)
        }
    }
}