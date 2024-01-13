package com.zinine.game.pipetycoonfree;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Statistics extends BaseFrame {
	
	private TextView tvStarEarned;
	private TextView tvYourName;
	private TextView tvTotalGames;
	private TextView tvTotalRounds;
	private TextView tvTotalPipes;
	private TextView tvHiscore;
	private TextView tvMaxRounds;
	private TextView tvMaxPipeGame;
	private TextView tvMaxPipeRound;
	private TextView tvNowVersion;
	private Button btStarEarned;
	private Button btYourName;
	private Button btHiscore;
	private Button btMaxRounds;
	private Button btMaxPipeGame;
	private Button btMaxPipeRound;
	private Button btUpdateHistory;
	private Button btGoBlog;
	private Button btSendEmail;
	private Button btMoreGames;
	private Toast toastUploadOk;
	private Toast toastUploadFail;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        tvStarEarned = (TextView)findViewById(R.id.starEarned);
        tvYourName = (TextView)findViewById(R.id.yourName);
        tvTotalGames = (TextView)findViewById(R.id.totalGames);
        tvTotalRounds = (TextView)findViewById(R.id.totalRounds);
        tvTotalPipes = (TextView)findViewById(R.id.totalPipes);
        tvHiscore = (TextView)findViewById(R.id.hiscore);
        tvMaxRounds = (TextView)findViewById(R.id.maxRounds);
        tvMaxPipeGame = (TextView)findViewById(R.id.maxPipeGame);
        tvMaxPipeRound = (TextView)findViewById(R.id.maxPipeRound);
        tvNowVersion = (TextView)findViewById(R.id.statNowVersion);
        btStarEarned = (Button)findViewById(R.id.buttonStarDetail);
        btYourName = (Button)findViewById(R.id.buttonName);
        btHiscore = (Button)findViewById(R.id.buttonHiscore);
        btMaxRounds = (Button)findViewById(R.id.buttonMaxRounds);
        btMaxPipeGame = (Button)findViewById(R.id.buttonMaxPipeGame);
        btMaxPipeRound = (Button)findViewById(R.id.buttonMaxPipeRound);
        btUpdateHistory = (Button)findViewById(R.id.buttonUpdateHistory);
        btGoBlog = (Button)findViewById(R.id.buttonGoBlog);
        btSendEmail = (Button)findViewById(R.id.buttonSendEmail);
        btMoreGames = (Button)findViewById(R.id.buttonMoreGames);
        btStarEarned.setOnClickListener(this);
        btYourName.setOnClickListener(this);
        btHiscore.setOnClickListener(this);
        btMaxRounds.setOnClickListener(this);
        btMaxPipeGame.setOnClickListener(this);
        btMaxPipeRound.setOnClickListener(this);
        btUpdateHistory.setOnClickListener(this);
        btGoBlog.setOnClickListener(this);
        btSendEmail.setOnClickListener(this);
        if (app.versionTStore) {
        	btMoreGames.setVisibility(View.INVISIBLE);
        } else {
        	btMoreGames.setOnClickListener(this);
        }
        
        tvStarEarned.setText(String.format("%d", app.starEarned));
        tvYourName.setText(app.userName);
        tvTotalGames.setText(String.format("%d", app.totalGames));
        tvTotalRounds.setText(String.format("%d", app.totalRounds));
        tvTotalPipes.setText(String.format("%d", app.totalPipes));
        tvHiscore.setText(String.format("%d", app.hiScore));
        tvMaxRounds.setText(String.format("%d", app.maxRounds));
        tvMaxPipeGame.setText(String.format("%d", app.maxPipeGame));
        tvMaxPipeRound.setText(String.format("%d", app.maxPipeRound));
        String strVersion = "0";
        try{
        	PackageManager pm = this.getPackageManager();
        	PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
        	strVersion = packageInfo.versionName;
        }
        catch(Exception e){}
        tvNowVersion.setText(strVersion);
		String msg3 = new String(getString(R.string.msgUploadOk));
		toastUploadOk = Toast.makeText(this, msg3, app.DEFAULT_SHOW_TOAST);
		toastUploadOk.setGravity(Gravity.CENTER, 0, 0);
		String msg4 = new String(getString(R.string.msgServerError));
		toastUploadFail = Toast.makeText(this, msg4, app.DEFAULT_SHOW_TOAST);
		toastUploadFail.setGravity(Gravity.CENTER, 0, 0);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonUpdateHistory:
			TextView msg=new TextView(this);
    		msg.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
    		msg.setTextColor(0xffffffff);
    		msg.setText(R.string.updateString);
    		new AlertDialog.Builder(this)
    		.setTitle(R.string.updateTitle)
    		.setView(msg)	    		
    		.setPositiveButton(R.string.updateConfirm, null)
    		.show();
			break;
		case R.id.buttonGoBlog:
			Intent blogIntent = new Intent(Intent.ACTION_VIEW);
			blogIntent.setData(Uri.parse(getString(R.string.zinineBlog)));
			startActivity(blogIntent);
			break;
		case R.id.buttonSendEmail:
			Intent i = new Intent(Intent.ACTION_SEND);
			i.addCategory(Intent.CATEGORY_DEFAULT);
			i.setType("text/plain");
			i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.statEmailSubject));
			i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.zinineEmail)});
			i.setType("message/rfc822"); 
			startActivity(Intent.createChooser(i, "Send Message"));
			break;
		case R.id.buttonMoreGames:
			Intent marketIntent = new Intent(Intent.ACTION_VIEW);
			marketIntent.setData(Uri.parse(getString(R.string.zinineMarket)));
			startActivity(marketIntent);
			break;
		case R.id.buttonStarDetail:
			Intent intentStar = new Intent(this, ListStar.class);
			intentStar.putExtra(app.KS_RESOURCE_FRAME, R.layout.z_list_star);
			intentStar.putExtra(app.KS_TYPE_BUTTON, app.TYPE_BUTTON_TEXT_RETURN);
			startActivity(intentStar);
			break;
		case R.id.buttonName:
			final AlertDialog.Builder ad = new AlertDialog.Builder(Statistics.this);
			ad.setTitle(R.string.msgEYNtitle);
			LayoutInflater factory = LayoutInflater.from(this);            
			final View textEntryView = factory.inflate(R.layout.dialog_name, null);
			final EditText edit = (EditText)textEntryView.findViewById(R.id.username_edit);
			edit.setText(app.userName);
			ad.setView(textEntryView);
			ad.setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int whichButton) {
	            	String editStr = edit.getText().toString();
	            	if (editStr.length() == 0) {
	            		editStr = getString(R.string.anonymous);
	            	}
	            	if (editStr.length() > app.MAX_LEN_USERNAME) {
	            		editStr = editStr.substring(0, app.MAX_LEN_USERNAME);
	            	}
	            	String fixStr = "";
	            	for (int cnt = 0; cnt < editStr.length(); cnt++) {
	            		// "34 &38 ,44
	            		if ((editStr.charAt(cnt) != 34) && (editStr.charAt(cnt) != 38) && (editStr.charAt(cnt) != 44)) {
	            			fixStr += editStr.charAt(cnt);
	            		}
	            	}
	            	app.userName = fixStr;
	            	app.saveSettings();
	            	tvYourName.setText(app.userName);
	            }
	        });
			ad.setNegativeButton(R.string.buttonCancel, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			ad.create();
   	        Statistics.this.runOnUiThread(new Runnable() { 
   	            public void run() {
   	            	ad.show(); 
   	            } 
   	        });
			break;
		case R.id.buttonHiscore:
		case R.id.buttonMaxRounds:
		case R.id.buttonMaxPipeGame:
		case R.id.buttonMaxPipeRound:
			Intent intentScore = app.newActivity(app.TYPE_ACTIVITY_RANKING, this, null, 0, 0, false);
			intentScore.putExtra(app.KS_TYPE_RANKING, v.getId());
			startActivity(intentScore);
			break;
		case R.id.buttonLeft:
			initializeNetwork();
			app.startNetwork(handler, this);
			break;
		case R.id.buttonRight:
			finish();
			break;
		}
	}
	
	@Override
	public void initializeNetwork() {
		app.networkType = app.TYPE_NETWORK_UPLOAD;
		app.networkPath = "http://zinine73.dothome.co.kr/pipetycoon/insert.php?aid=";
		app.networkPath += app.getAndroidID();
		app.networkPath += "&name=";
		app.networkPath += app.getUserName();
		app.networkPath += "&lo=";
		app.networkPath += app.getUserLocale();
		app.networkPath += "&uk=";
		app.networkPath += app.getVersion();
		app.networkPath += "&se=";
		app.networkPath += app.starEarned;
		app.networkPath += "&tg=";
		app.networkPath += app.totalGames;
		app.networkPath += "&tr=";
		app.networkPath += app.totalRounds;
		app.networkPath += "&tp=";
		app.networkPath += app.totalPipes;
		app.networkPath += "&hs=";
		app.networkPath += app.hiScore;
		app.networkPath += "&mr=";
		app.networkPath += app.maxRounds;
		app.networkPath += "&mpg=";
		app.networkPath += app.maxPipeGame;
		app.networkPath += "&mpr=";
		app.networkPath += app.maxPipeRound;
	}
	
	@Override
	public void networkSuccess() {
		toastUploadOk.show();
	}
	
	@Override
	public void networkFail() {
		toastUploadFail.show();
	}
}