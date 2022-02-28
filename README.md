# TranslationApp 
❗Android Studio&Java Language(3 layout.xml , 7 java class).

part of Udacity One Million Arab Coders inititive , Android Development course
MiwokTranslationApp : displaying  Miwok word translated into English and when you tab on a word or the listItem an audio pronunciation will be played
➡️ home screen layout file displaying four category , customized listItem Layout file,Empty ListView layout file and four intents containing each category listItems
➡️home screen: RelativeLayout containing four categories displayed as grid view
   Numbers , Colors , Family Members and Phrases
➡️Each category inflate ListItem View from wordAdapter class : containing 4 Views (TextView:Miwok word ,TextView: English word, imageView:expressing the word and play audio icon) all of that data stored in ArrayList and managed by an ArrayAdapter.
➡️Word java class containing 4 strings ,2 integers and two constructor and 4 getter methods
two string values: one for miwok word and one for the translation(english) ,two integer values to store the image and the audio Id. 
two Constructors because Phrases Activity doesn't have an image in it but the rest of the activities does.
➡️WordAdapter class: inflate the customized list item layout file 
➡️Each category(Activity) java class :containing An ArrayList of word class object / ArrayAdapter / ListView.OnItemClickListener / MediaPlayer.OnCompletionListener 
AudioManager / AudioManager.OnAudioFocusChangeListener / releaseMediaPlayerResource method / onStop method

   


![Screenshot_20220228-034022](https://user-images.githubusercontent.com/37903508/155911023-ceb11560-342b-4c92-96e3-6f1be8f88c6c.png)

