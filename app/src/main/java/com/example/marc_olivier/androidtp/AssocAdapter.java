class AssocAdapter extends BaseAdapter implements ListAdapter {
protected Context context ;
public AssocAdapter(Context context) {
super() ;
this.context = context ;
}
@Override
public boolean areAllItemsEnabled() { return true ; }
@Override
public boolean isEnabled(int position) { return true ; }
@Override
public int getCount() { return modele.getCount() ; }
@Override
public Integer getItem(int position) { return modele.getStudent(position) ; }
@Override
public long getItemId(int position) { return position ; }
@Override
public int getItemViewType(int position) { return 0 ; }
@Override
public int getViewTypeCount() { return 1 ; }
@Override
public boolean hasStableIds() { return true ; }
@Override
public boolean isEmpty() { return (getCount() == 0) ; }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
LayoutInflater inflater = getLayoutInflater() ;
View row = inflater.inflate(R.layout.layout_association, parent, false) ;
TextView tvTablette = (TextView) row.findViewById(R.id.tvTablette) ;
tvTablette.setText(modele.getTerminal(position)) ;
Spinner spStudent = (Spinner) row.findViewById(R.id.spStudent) ;
spStudent.setAdapter(studentAdapter);
spStudent.setOnItemSelectedListener(
new StudentListener(context, position, spStudent));
spStudent.setSelection(modele.getStudent(position));
return row ;
}
}