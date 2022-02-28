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

   



![Screenshot_20220228-034057](https://user-images.githubusercontent.com/37903508/155910906-bdaf4067-3669-41d3-91d7-6eeb3ef879cf.png)
![Screenshot_20220228-034132](https://user-images.githubusercontent.com/37903508/155910898-cf3522a7-25ef-4576-93e3-aea111010469.png)
![Screenshot_20220228-034143](https://user-images.githubusercontent.com/37903508/155910901-b4646d1c-60ed-4574-a9c8-4a1606cf49fe.png)
![Screenshot_20220228-034022](https://user-images.githubusercontent.com/37903508/155910903-699a2fca-2986-44ba-b393-f099ac253724.png)
![Screenshot_20220228-034120](https://user-images.githubusercontent.com/37903508/155910908-23f1cff3-3c8e-49d7-88eb-0ef09a4e0be7.png)
