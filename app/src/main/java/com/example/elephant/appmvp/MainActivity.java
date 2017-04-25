package com.example.elephant.appmvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.elephant.interfaceImp.main.FindItemsInteractorImpl;
import com.example.elephant.interfaceImp.main.MainPresenter;
import com.example.elephant.interfaceImp.main.MainPresenterImpl;
import com.example.elephant.view.main.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener,
        AdapterView.OnItemClickListener{
    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        mainPresenter = new MainPresenterImpl(this,new FindItemsInteractorImpl());
    }

    @Override protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mainPresenter.onItemClicked(position);
    }
}
