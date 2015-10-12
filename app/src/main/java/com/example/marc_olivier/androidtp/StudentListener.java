/**
* Classe qui répercute sur le modèle le changement de séléection d'un spinner
* par le biais d'un traitemlent de l'événement onItemSelected.
* Si la mise à jour ne peut se faire, il y a affichage d'une fenêtre d'avertissement.
* Le context Android ainsi que la position traitée sont fournis par le constructeur.
*/
class StudentListener implements AdapterView.OnItemSelectedListener {
protected int position ;
protected Context context ;
protected Spinner spStudent ;
/**
* Constructeur.
* @param context Le contexte Android.
* @param position La position (c.a.d. le terminal) associée.
* @param spStudent Le spinner contrôlé.
*/
public StudentListener(Context context, int position, Spinner spStudent) {
this.position = position ;
this.context = context ;
this.spStudent = spStudent ;
}
/**
* Déselection du spinner.
* @param parent
*/
public void onNothingSelected(AdapterView<?> parent) {
Toast.makeText(context,"unselect",Toast.LENGTH_SHORT).show();
}
/**
* Selection d'un élément.
* @param parent
* @param view
* @param position
* @param id
*/
public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
{
/* Le modele est un attribut de la classe englobante. MainActivty */
if (!(modele.setStudent(this.position, position))) {
Toast.makeText(context,
context.getResources().getText(R.string.err_01),Toast.LENGTH_SHORT).show();
spStudent.setSelection(modele.getStudent(this.position));
}
}
}