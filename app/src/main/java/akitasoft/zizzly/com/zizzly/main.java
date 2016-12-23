package akitasoft.zizzly.com.zizzly;

import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.Time;
import java.util.Date;
import java.util.Random;


public class main extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void createLoginView() {
        final Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // email
                final TextView login_email = (TextView) findViewById(R.id.login_email);
                String usr_email = login_email.getText().toString();

                // password
                final TextView login_password = (TextView) findViewById(R.id.login_password);
                String usr_password = login_password.getText().toString();

                if (usr_email.equals("m") && usr_password.equals("p")) {
                    Log.v("login", "Successful login");
                    setContentView(R.layout.venue);
                    createVenueView();
                }
            }
        });
    }

    protected void createVenueView() {
        final Button venue_upgrade_btn = (Button) findViewById(R.id.venue_upgrade_btn);
        venue_upgrade_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("venue", "upgrade selected");
                setContentView(R.layout.seat);
                createSeatView();
            }
        });
    }

    protected void createSeatView() {
        final Button seat_bidNow_btn = (Button) findViewById(R.id.seat_bidNow_btn);
        seat_bidNow_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("seat", "entering auction");
                setContentView(R.layout.auction);
                createAuctionView();
            }
        });
    }

    protected void createAuctionView() {

        final TextView auction_s100t2_view = (TextView) findViewById(R.id.auction_s100t2);
        auction_s100t2_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s100t2");
                setContentView(R.layout.bid);
                createBidView("Section 100", 2, 15);
            }
        });
        final TextView auction_s100t3_view = (TextView) findViewById(R.id.auction_s100t3);
        auction_s100t3_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s100t3");
                setContentView(R.layout.bid);
                createBidView("Section 100", 3, 15);
            }
        });
        final TextView auction_s100t4_view = (TextView) findViewById(R.id.auction_s100t4);
        auction_s100t4_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s100t4");
                setContentView(R.layout.bid);
                createBidView("Section 100", 4, 15);
            }
        });
        final TextView auction_s200t2_view = (TextView) findViewById(R.id.auction_s200t2);
        auction_s200t2_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s200t2");
                setContentView(R.layout.bid);
                createBidView("Section 200", 2, 15);
            }
        });
        final TextView auction_s200t3_view = (TextView) findViewById(R.id.auction_s200t3);
        auction_s200t3_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s200t3");
                setContentView(R.layout.bid);
                createBidView("Section 200", 3, 15);
            }
        });
        final TextView auction_s200t4_view = (TextView) findViewById(R.id.auction_s200t4);
        auction_s200t4_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("auction", "auction_s200t4");
                setContentView(R.layout.bid);
                createBidView("Section 200", 4, 15);
            }
        });
    }

    protected void createBidView(String section, int tickets, int bidders) {

        final TextView bid_description_view = (TextView) findViewById(R.id.bid_description);
        bid_description_view.setText(section + " (" + tickets + " tickets)");

        final TextView bid_timeRemaining_view = (TextView) findViewById(R.id.bid_timeRemaining);
        Random random=new Random();
        int secondsToBid=(random.nextInt(500-30)+10)*1000;
        new CountDownTimer(secondsToBid, 1000) {
            public void onTick(long millisUntilFinished) {
                int minutes = (int)(millisUntilFinished/1000) / 60;
                int seconds = (int)(millisUntilFinished/1000) % 60;
                bid_timeRemaining_view.setText(minutes + ":" + seconds);
            }
            public void onFinish() {
                bid_timeRemaining_view.setText("done!");
            }
        }.start();

        final TextView bid_currentBid_view = (TextView) findViewById(R.id.bid_currentBid);
        final int[] currentBid = {(random.nextInt(100 - 25) + 25)};
        bid_currentBid_view.setText("Current Bid: $" + currentBid[0]);

        final Button bid_oneDollar_btn = (Button) findViewById(R.id.bid_oneDollar);
        bid_oneDollar_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("bid","bid one dollar");
                currentBid[0] += 1;
                bid_currentBid_view.setText("Current Bid: $" + currentBid[0]);
            }
        });

        final Button bid_fiveDollar_btn = (Button) findViewById(R.id.bid_fiveDollar);
        bid_fiveDollar_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("bid","bid five dollar");
                currentBid[0] += 5;
                bid_currentBid_view.setText("Current Bid: $" + currentBid[0]);
            }
        });

        final Button bid_tenDollar_btn = (Button) findViewById(R.id.bid_tenDollar);
        bid_tenDollar_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("bid","bid ten dollar");
                currentBid[0] += 10;
                bid_currentBid_view.setText("Current Bid: $" + currentBid[0]);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Login button
        setContentView(R.layout.login);
        createLoginView();

        // Venue
        // Seat
        // Auction
        // Bid

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
