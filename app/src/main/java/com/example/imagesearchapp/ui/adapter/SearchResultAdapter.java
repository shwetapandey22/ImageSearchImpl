/*
 * *
 *  * Created by Shweta Pandey on 8/9/19 3:53 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/9/19 3:47 PM
 *
 */

package com.example.imagesearchapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagesearchapp.R;
import com.example.imagesearchapp.model.Hit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchViewHolder> {

	private List<Hit> searchResult;
	private OnItemClickListener listener;
	private Context context;

	public interface OnItemClickListener {
		void onItemClick(Hit item);
	}

	public SearchResultAdapter(Context context, List<Hit> searchResult, OnItemClickListener listener) {
		this.searchResult = searchResult;
		this.listener = listener;
		this.context = context;
	}

	@NonNull
	@Override
	public SearchResultAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_row, parent, false);
		return new SearchViewHolder(view);
	}


	@Override
	public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
			final Hit item = searchResult.get(position);

			Picasso.with(context).load(item.getWebformatURL()).into(holder.imageView);
			holder.imageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					listener.onItemClick(item);
				}
			});

	}

	@Override
	public int getItemCount() {
		return searchResult.size();
	}

	public class SearchViewHolder extends RecyclerView.ViewHolder {
		ImageView imageView;

		public SearchViewHolder(@NonNull View itemView) {
			super(itemView);
			imageView = itemView.findViewById(R.id.image_view);
		}
	}
}
