package com.kenmeidearu.searchablespinnerlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by kenjin on 8/10/2016.
 */
public class ListAdapterSpinner extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<mListString> worldpopulationlist = null;
    private ArrayList<mListString> arraylist;
    int type;


    public ListAdapterSpinner(Context context, List<mListString> worldpopulationlist, int type, String firstItem) {
        mContext = context;
        ArrayList<mListString> temp = new ArrayList<>();
        if (!TextUtils.isEmpty(firstItem)) {
            temp.add(new mListString(0, firstItem));
            temp.addAll(worldpopulationlist);
            this.worldpopulationlist = temp;
        } else {
            this.worldpopulationlist = worldpopulationlist;
        }
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(worldpopulationlist);
        this.type = type;

    }


    public int indexOf(mListString objects) {
        return arraylist.indexOf(objects);
    }

    public int indexOf(int index) {
        return index;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public mListString getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            if (type == 0) {
                v = vi.inflate(R.layout.spinner_item_code_with_image, null);
            } else if (type == 1) {
                v = vi.inflate(R.layout.spinner_item_code_1, null);
            } else if (type == 2) {
                v = vi.inflate(R.layout.spinner_item_code_2, null);
            } else if (type == 3) {
                v = vi.inflate(R.layout.spinner_item_code_3, null);
            } else if (type == 4) {
                v = vi.inflate(R.layout.spinner_item_code_4, null);
            } else {
                v = vi.inflate(R.layout.spinner_item_code_1, null);
            }
            holder = new ViewHolder();
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }

        if (type == 0) {
            holder.images=(ImageView)v.findViewById(R.id.images);
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
            holder.nilai2 = (TextView) v.findViewById(R.id.sub);
        } else if (type == 1) {
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
        } else if (type == 2) {
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
            holder.nilai2 = (TextView) v.findViewById(R.id.sub);
        } else if (type == 3) {
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
            holder.nilai2 = (TextView) v.findViewById(R.id.sub);
            holder.nilai3 = (TextView) v.findViewById(R.id.sideHead);
        } else if (type == 4) {
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
            holder.nilai2 = (TextView) v.findViewById(R.id.sub);
            holder.nilai3 = (TextView) v.findViewById(R.id.sideHead);
            holder.nilai4 = (TextView) v.findViewById(R.id.sideSub);
        } else {
            holder.nilai1 = (TextView) v.findViewById(R.id.spinnerHead);
        }

        mListString p = getItem(position);
        if (p != null) {
            String val1, val2, val3, val4,valImage;
            val1 = p.getNilai1();
            val2 = p.getNilai2();
            val3 = p.getNilai3();
            val4 = p.getNilai4();
            valImage=p.getImageName();

            if (holder.nilai1 != null) {
                holder.nilai1.setText(val1);
            }
            if (holder.nilai2 != null) {
                holder.nilai2.setText(val2);
            }
            if (holder.nilai3 != null) {
                holder.nilai3.setText(val3);
            }
            if (holder.nilai4 != null) {
                holder.nilai4.setText(val4);
            }
            if(holder.images!=null){

                Picasso.with(mContext).setLoggingEnabled(true);
                Picasso.with(mContext)
                        .load(valImage)
                        .placeholder(R.drawable.noimage)
                        .error(R.drawable.noimage)
                        .into(holder.images);
               /* Picasso.with(mContext).setLoggingEnabled(true);
                Picasso picasso = new Picasso.Builder(mContext).listener(new Picasso.Listener() {
                    @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        exception.printStackTrace();
                    }
                }).build();
                picasso.load(valImage)
                        .placeholder(R.drawable.noimage)
                        .error(R.drawable.noimage)
                        .into(holder.images);*/
                Log.e("isi image",p.getNilai1()+" image:"+valImage);
            }
        }


        return v;
    }

    public class ViewHolder {
        public TextView nilai1, nilai2 = null, nilai3 = null, nilai4 = null;
        public ImageView images=null;
    }

    // Filter Class
    public void filter(String charText, int filter) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } else {
            if (filter > type) filter = type;
            if (filter == 1) {
                for (mListString wp : arraylist) {
                    String nilai1 = "";
                    if (wp.getNilai1() != null) nilai1 = wp.getNilai1();
                    if (nilai1.toLowerCase(Locale.getDefault()).contains(charText)) {
                        worldpopulationlist.add(wp);
                    }

                }

            } else if (filter == 2) {
                for (mListString wp : arraylist) {
                    String nilai1 = "", nilai2 = "";
                    if (wp.getNilai1() != null) nilai1 = wp.getNilai1();
                    if (wp.getNilai3() != null) nilai2 = wp.getNilai2();
                    if (nilai1.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai2.toLowerCase(Locale.getDefault()).contains(charText)
                            ) {
                        worldpopulationlist.add(wp);
                    }

                }

            } else if (filter == 3) {
                for (mListString wp : arraylist) {
                    String nilai1 = "", nilai2 = "", nilai3 = "";
                    if (wp.getNilai1() != null) nilai1 = wp.getNilai1();
                    if (wp.getNilai3() != null) nilai2 = wp.getNilai2();
                    if (wp.getNilai3() != null) nilai3 = wp.getNilai3();
                    if (nilai1.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai2.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai3.toLowerCase(Locale.getDefault()).contains(charText)
                            ) {
                        worldpopulationlist.add(wp);
                    }

                }

            } else if (filter == 4) {
                for (mListString wp : arraylist) {
                    String nilai1 = "", nilai2 = "", nilai3 = "", nilai4 = "";
                    if (wp.getNilai1() != null) nilai1 = wp.getNilai1();
                    if (wp.getNilai3() != null) nilai2 = wp.getNilai2();
                    if (wp.getNilai3() != null) nilai3 = wp.getNilai3();
                    if (wp.getNilai4() != null) nilai4 = wp.getNilai4();

                    if (nilai1.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai2.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai3.toLowerCase(Locale.getDefault()).contains(charText) ||
                            nilai4.toLowerCase(Locale.getDefault()).contains(charText)
                            ) {
                        worldpopulationlist.add(wp);
                    }
                }

            } else {
                for (mListString wp : arraylist) {
                    String nilai1 = "";
                    if (wp.getNilai1() != null) nilai1 = wp.getNilai1();
                    if (nilai1.toLowerCase(Locale.getDefault()).contains(charText)) {
                        worldpopulationlist.add(wp);
                    }

                }
            }

        }
        notifyDataSetChanged();
    }
}
