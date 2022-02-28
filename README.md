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


![Screenshot_20220228-034057](https://user-images.githubusercontent.com/37903508/155911052-eaef0ce2-8f17-4220-b2df-48d5b6de76e6.png)
![Screenshot_20220228-034120](https://user-images.githubusercontent.com/37903508/155911079-b0a96cf5-3dfa-4857-bc3a-c4ecb1178bcc.png)


![Screenshot_20220228-034132](https://user-images.githubusercontent.com/37903508/155911093-f4ea20d4-f75b-4f5b-9069-a69fd024d8ec.png)


![Screenshot_20220228-034143](https://user-images.githubusercontent.com/37903508/155911112-67f76add-76d3-4777-b7a2-897ca6ffa720.png)
