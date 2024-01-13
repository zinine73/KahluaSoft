package com.zinine.game.pipetycoonfree;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListPuzzle extends ListActivity {
	// customlistview edit rowstuff
	class RowStuff {
		public String title;
		public String text;
		public RowStuff(String inTitle, String inText){
			title = inTitle;
	      	text = inText;
		}
	}
	// --
	
	private ArrayList<RowStuff> items = new ArrayList<RowStuff>();
	// customlistview local values
	private static final int MAX_PUZZLE = 7;
	private static final String KEY_STRING_PUZZLE = "PUZZLE_CLEARED";
	private static final String KEY_STRING_NOW_PUZZLE = "NOW_PUZZLE";
	private int puzzleCleared;
	private int nowPuzzle;
	// --
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.list_tutorial);
		// customlistview set title
		setTitle(getString(R.string.app_name) + " : " + getString(R.string.buttonPuzzle));
		// --
		
		// customlistview get values from parent
		Bundle extras = getIntent().getExtras();
	    puzzleCleared = extras.getInt(KEY_STRING_PUZZLE);
	    nowPuzzle = extras.getInt(KEY_STRING_NOW_PUZZLE);
	    // --
	    
	    // customlistview set row datas
	    for (int cnt=0; cnt<MAX_PUZZLE; cnt++) {
	    	items.add(new RowStuff(getString(R.string.puzzleTitle, cnt + 1), null));
	    }
	    // --
		setListAdapter(new CustomAdapter(this, R.layout.z_row_tutorial, items));
	}
 
	public void onListItemClick(ListView parent, View v, int position, long id) {
		// customlistview user action
		if (position < puzzleCleared) {
			Intent intent = getIntent();
			intent.putExtra(KEY_STRING_NOW_PUZZLE, position);
			setResult(RESULT_OK, intent);
			finish();
		}
		// --
	}
 
	private class CustomAdapter extends ArrayAdapter<RowStuff> {
        private ArrayList<RowStuff> items;
        public CustomAdapter(Context context, int textViewResourceId, ArrayList<RowStuff> items) {
        	super(context, textViewResourceId, items);
        	this.items = items;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        	View view = convertView;
        	if (view == null) {
        		LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        		view = vi.inflate(R.layout.z_row_tutorial, null);
        	}
        	RowStuff rowStuff = items.get(position);
        	if (rowStuff != null) {
        		// customlistview show row data
        		ImageView imageView = (ImageView)view.findViewById(R.id.lrow_image);
        		TextView textTitle = (TextView)view.findViewById(R.id.lrow_label1);
        		TextView textText = (TextView)view.findViewById(R.id.lrow_label2);
        		if (position < puzzleCleared) {
        			imageView.setImageResource((position == nowPuzzle) ? R.drawable.icon_radio_on : R.drawable.icon_radio_off);
        		} else {
        			imageView.setImageResource(R.drawable.icon_lock);
        		}
        		if (textTitle != null){
        			textTitle.setText(rowStuff.title);                            
        		}
        		if (position + 1 < puzzleCleared) {
        			textText.setTextColor(Color.YELLOW);
        			textText.setText(R.string.puzzleCleared);
        		}
        		// --
        	}
        	return view;
        }
    }
}