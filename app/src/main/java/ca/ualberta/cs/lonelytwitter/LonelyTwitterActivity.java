package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*
 *The main activity for a small personal twitter app to capture , <br>comments and notes
 * <p>It saves the <pre>input tweets</pre> in the json files.</p>
 * A sample code is at:<br>
 *     	<code>
 *     	    for(int i=0; i<10;i++)
 *     	    	for (int j=0;j<i; j++)
 *     	    		doSomething();
 *  </code>
 * The list of important activities in this class are:
 * <ul>
 *     	<li> item 1</li>
 *     	<li> item 2</li>
 *     	<li> item 3</li>
 *     	<li> item 4</li>
 *</ul>
 * @since 1.2.1
 * @see LonelyTwitterActivity for more information
 * @author Brosda
 * @version 2.3
 * @deprecated
 *
 */

public class LonelyTwitterActivity extends Activity {
	/**
	 * This arraylist is for keeping tweets
	 * This is blah blah.
	 * @see #loadFromFile()
	 */
	public ArrayList<String> listofItems;

	static final String FILE_NAME  = "fileName.json"; //constants in capitals

	/**
	 * this function returns the size of a tweet;
	 * @return
	 * @deprecated
	 */
	private int calculateTweetSize() {
		//
		return -1;
	}

	/**
	 * Is supposed to remove word stops from given parameter
	 * @param text String passed in to have StopWords removed
	 * @return
	 */
	private String removeStopWords(String text){
		//
		return "";
	}

	/**
	 * supposed to evaluate the intent passed
	 * @param intent
	 */
	private void evaluateotherActivity(Intent intent){
		//
	}

	/**
	 *
	 * @param s1
	 * @return the value returned for some job
	 * @throws exception blah blah.
	 * @deprecated
	 *
	 */
	public String someMethod(String s1) {
		return "";
	}

	/**
	 * This starts the next activity which is blah blah.
	 * @param intent this is the intent to be run immediatly after hitting "start button"
	 * @return
	 */
	public boolean startSecongActivity(Intent intent){
		int count = 0;
		Intent intent1 = new Intent();
		String expression1 = "";
		String expression2 = "";
		String expression3 = "";
		String expression4 = "";
		startSecongActivity(intent1);
		String S = someMethod(expression1 + expression2+expression3
								+ expression4);
		someMethod(expression1 +expression2+expression3
				+ expression4);
		for (int i=0;i<10;i++) {

		}
		try {
			int a =1;
			int b = 2;
			if (a<2) {
				someMethod("firstchoice");
			} else {
				someMethod("Second choice");
			}
			while (1 < 2) {
				int j = 0;
				//
			}
		}catch(Exception e){}
		return true;
	}

	private static final String FILENAME = "file.sav";
	/**
	 * EditText used to fill listView Item with all the tweets
	 */
	private EditText bodyText;
	/**
	 * The listview for displaying the saved tweets
	 */
	private ListView oldTweetsList;

	/**
	 * an arraylist of Tweet objects
	 * @see #saveInFile()
	 */
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		/**
		 * sets up the save button to be a listener
		 */
		Button saveButton = (Button) findViewById(R.id.save);
		/**
		 * sets up the clear button to be a listener
		 */
		Button clearButton = (Button) findViewById(R.id.clear);


		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * listens to the saveButton for clicks
		 * when button is clicked saves the text in bodyText as a new Tweet item
		 * adds the new Tweet to the tweets list
		 * notifies the adpater of the chages and saves the tweetlist to json
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				// latestTweet.setMessage(latestTweet.getMessage() + "!");
				tweets.add(latestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

		/**
		 * listens for when the clear button is clicked
		 * removes all the tweets from the list and saves this to json
		 */
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick( View v) {
				setResult(RESULT_OK);
				tweets.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}


	/**
	 * When the activity is started:
	 * loads the saved tweet list from json
	 * creates the adapter object
	 * initializes the Adapter
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Will load the list of saved tweets from json
	 * redies the buffers and input streams
	 * saves the file from json to tweets
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Saves the list tweets to json
	 * opens output stream
	 * saves the list tweets to json
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}