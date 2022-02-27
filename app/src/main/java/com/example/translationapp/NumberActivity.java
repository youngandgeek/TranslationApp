package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mAudioListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
             if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };


        //copy this and paste it in other java category just replace the words in arrayList
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.word_list);

            // Create and setup the {@link AudioManager} to request audio focus
            mAudioManager =(AudioManager) getSystemService(this.AUDIO_SERVICE);

            //arraylist of word objects(from word Class we created) to store numbers

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
            words.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
            words.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
            words.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
            words.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
            words.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
            words.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
            words.add(new Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
            words.add(new Word("Nine", "Wo’e", R.drawable.number_nine, R.raw.number_nine));
            words.add(new Word("Ten", "Na’aacha", R.drawable.number_ten, R.raw.number_ten));

            // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
            // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
            // in the list.
            WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers);
            // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
            // in the list.
            // Get a reference to the ListView, and attach the adapter to the listView.
            ListView listView = (ListView) findViewById(R.id.List);
            listView.setAdapter(wordAdapter);        // Get a reference to the ListView, and attach the adapter to the listView.

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                   // Get the {@link Word} object at the given position the user clicked on

                     Word word = words.get(position);

                     // Release the media player if it currently exists because we are about to
                    // play a different sound file
                    releaseMediaPlayer();


                    // short audio file, so we will request audio focus with a short amount of time
                    // with AUDIOFOCUS_GAIN_TRANSIENT.
                    int result= mAudioManager.requestAudioFocus(mAudioListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                        // We have audio focus now.


                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                        // with the current word
                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                        // with the current word
                        mediaPlayer = MediaPlayer.create(NumberActivity.this, word.getAudioResource());
                        mediaPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing.
                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }


                }
            });
        }

    @Override
    protected void onStop() {
        super.onStop();
        /* When the activity is stopped, release the media player resources because we won't
         * be playing any more sounds.
         */
        releaseMediaPlayer();
    }

    //call the method in OnStop method so its stops as soon as the user leave the window
        /**
         * Clean up the media player by releasing its resources.
         */
        private void releaseMediaPlayer() {
            // If the media player is not null, then it may be currently playing a sound.
            if (mediaPlayer != null) {
                // Regardless of the current state of the media player, release its resources
                // because we no longer need it.
                mediaPlayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                mediaPlayer = null;
                // Regardless of whether or not we were granted audio focus, abandon it. This also
                // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
                mAudioManager.abandonAudioFocus(mAudioListener);
            }
        }
/*ArrayAdapter(list of word) to display the ListView we created in xml file(this,customList_item_layout,ArrayList);
ArrayAdapter<Word> itemsAdapter= new ArrayAdapter<Word>(this, R.layout.list_item_layout ,words);
        ListView listView=(ListView) findViewById(R.id.List);
        listView.setAdapter(itemsAdapter);



        /* ArrayList of String
         ArrayList<String>words=new ArrayList<String>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("Ten");
/*
//ArrayAdapter to display the ListView we created in xml file(this,predefined layout by android studio,ArrayList);
ArrayAdapter<String> itemsAdapter= new ArrayAdapter<>(this, R.layout.list_item_layout ,words);
        ListView listView=(ListView) findViewById(R.id.List);
        listView.setAdapter(itemsAdapter);

         */
/*         to show arraylist on screen first: get the parent view and cast it to linearlayout so we can add childView to it

       LinearLayout rootView=(LinearLayout) findViewById(R.id.rootVi
        //second:add a child View of type TextView
        //add a loop so it can go though all the arrayList index
/* remove the loop and add ArrayAdapter
        for (int index=0; index<words.size(); index++){
            TextView wordView=new TextView(this);
//third: ( Set the text to be word at the current index)
            wordView.setText(words.get(index));
//pass the child view to the parent view so it can shows on screen
            rootView.addView(wordView);
//increment the index by 1

        }
*/

/*array of String to show numbers from one to ten
        String[] numbersToTen =new String[10];
        numbersToTen[0]="One";
        numbersToTen[1]="Two";
        numbersToTen[2]="Three";
        numbersToTen[3]="Four";
        numbersToTen[4]="Five";
        numbersToTen[5]="Six";
        numbersToTen[6]="Seven";
        numbersToTen[7]="Eight";
        numbersToTen[8]="Nine";
        numbersToTen[9]="Ten";
*/







        }

