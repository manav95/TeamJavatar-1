package com.example.teamjavatar.application;

import java.util.List;

import com.example.teamjavatar.R;
import com.example.teamjavatar.domain.Account;
import com.example.teamjavatar.domain.database.AccountDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class UserIndexActivity extends Activity {

	/*
	 * Creator pattern
	 * creates an accountDAO object to manage accounts in the database
	 */
	private AccountDAO accountDataSource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_index);
		
		accountDataSource = new AccountDAO(this);
		accountDataSource.open();
		
		setListView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_index, menu);
		return true;
	}

	public void addAccount(View view){
    	Intent intent = new Intent(this, AddAccountActivity.class);
    	startActivity(intent);
	}
	
	public void manageAccount(View view, Account account) {
		UserApplication app = (UserApplication) getApplication();
		app.setAccount(account);
		Intent intent = new Intent(this, AccountHistoryActivity.class);
		startActivity(intent);
	}
	
	public void gotoSpendingReportDate(View view) {
		Intent intent = new Intent(this, SelectSpendingCategoryDateActivity.class);
		startActivity(intent);
	}
	
	public void goToReportDisplay(View view) {
		Intent intent = new Intent(this, ReportDisplayActivity.class);
		startActivity(intent);
	}
	
	public void setListView() {
		UserApplication app = (UserApplication) this.getApplication();
		String userID = app.getUser().getID();
		List<Account> accounts = accountDataSource.getAccountsList(userID); 
		ListView listView = (ListView) findViewById(R.id.listview);
		ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this, R.layout.list_item, R.id.listItemTextView, accounts);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnListItemClickListener());
        listView.setClickable(true);
	}
	
	private class OnListItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Account account = (Account) parent.getItemAtPosition(position);
			manageAccount(view, account);
		}
		
	}
	
}
