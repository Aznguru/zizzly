package akitasoft.zizzly.com.zizzly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class main extends AppCompatActivity {

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

    }

    protected void createBidView() {

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

    }
}
