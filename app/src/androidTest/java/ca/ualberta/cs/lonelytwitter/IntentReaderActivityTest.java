
    package ca.ualberta.cs.lonelytwitter;

    import android.content.Intent;
    import android.test.ActivityInstrumentationTestCase2;
    import android.test.ViewAsserts;
    import android.view.View;
    import android.widget.TextView;

    /**
     * Created by sajediba on 2/8/16.
     */
    public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

        public IntentReaderActivityTest() {
            super(IntentReaderActivity.class);
        }

        public void testSendText(){
            Intent intent = new Intent();
            intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 1");

            setActivityIntent(intent);
            IntentReaderActivity lra = (IntentReaderActivity) getActivity();

            assertEquals("IntentReaderActivity shoud get the text from intent", "message 1", lra.getText());
        }
        public void testDisplayText() {
            Intent intent = new Intent();
            intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 2");

            setActivityIntent(intent);
            IntentReaderActivity lra = (IntentReaderActivity) getActivity();

            TextView textView = (TextView) lra.findViewById(R.id.intentText);
            assertEquals("The text should be displayed!", "message 2", textView.getText());
        }

        public void testDoubleText(){
            Intent intent = new Intent();
            intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 3");
            intent.putExtra((IntentReaderActivity.MODE_OF_TRANSFORM_KEY), IntentReaderActivity.DOUBLE);

            setActivityIntent(intent);
            IntentReaderActivity lra = (IntentReaderActivity) getActivity();
            assertEquals(("The text should be repeated twice!"), "message 3message 3", lra.getText());
        }

        //TODO: Add your code here ...
//-------------------------------------------------------------------------------

        public void testReverseText() {
            Intent intent = new Intent();
            intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 4");
            intent.putExtra((IntentReaderActivity.MODE_OF_TRANSFORM_KEY), IntentReaderActivity.REVERSE);
            setActivityIntent(intent);
            IntentReaderActivity lra = (IntentReaderActivity) getActivity();

            assertEquals("The text should be displayed in reverse", "4 egassem", lra.getText());
        }

        public void testDefaultText() {
            Intent intent = new Intent();
            setActivityIntent(intent);
            IntentReaderActivity lra = (IntentReaderActivity) getActivity();

            assertEquals("The text should be default", "Default text", lra.getText());
        }

        public void testVisible() {
            Intent intent = new Intent();
            setActivityIntent(intent);

            IntentReaderActivity lra = (IntentReaderActivity) getActivity();
            View view = lra.getWindow().getDecorView();
            TextView textview = (TextView) lra.findViewById(R.id.intentText);
            ViewAsserts.assertOnScreen(view, textview);


        }
//-------------------------------------------------------------------------------
    }
