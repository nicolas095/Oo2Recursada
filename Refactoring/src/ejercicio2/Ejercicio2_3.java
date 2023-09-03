package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
class Usuario{
	
}
class Post{

	public Object getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFecha() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class Ejercicio2_3 {
	private List<Post>posts = new ArrayList<Post>();
	/**
	 * Retorna los últimos N posts que no pertenecen al usuario user
	 */
	public List<Post> ultimosPosts(Usuario user, int cantidad) {
		List<Post> postsOtrosUsuarios = new ArrayList<Post>();
		for (Post post : this.posts) {
			if (!post.getUsuario().equals(user)) {
				postsOtrosUsuarios.add(post);
			}
		}
		// ordena los posts por fecha
		for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
			int masNuevo = i;
			for (int j = i + 1; j < postsOtrosUsuarios.size(); j++) {
				if (postsOtrosUsuarios.get(j).getFecha().isAfter(postsOtrosUsuarios.get(masNuevo).getFecha())) {
					masNuevo = j;
				}
			}
			Post unPost = postsOtrosUsuarios.set(i, postsOtrosUsuarios.get(masNuevo));
			postsOtrosUsuarios.set(masNuevo, unPost);
		}
		List<Post> ultimosPosts = new ArrayList<Post>();
		int index = 0;
		Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
		while (postIterator.hasNext() && index < cantidad) {
			ultimosPosts.add(postIterator.next());
		}
		return ultimosPosts;
	}
}
/**(i) Metodo Largo,
(ii) Se utiliza Extract Method para crear dos metodos nuevos donde en uno se buscarian los post que no pertenecen al usuario enviado por
parametro y otro metodo que se encargaria de ordenar por fecha.
(iii) Resolucion
*/


/**
 * Retorna los últimos N posts que no pertenecen al usuario user
 */
public List<Post> ultimosPosts(Usuario user, int cantidad) {
	List<Post> postsOtrosUsuarios = new ArrayList<Post>();
	this.postOtrosUsuarios(postsOtrosUsuarios, user);
	this.ordenarPostPorFecha(postsOtrosUsuarios);
	List<Post> ultimosPosts = new ArrayList<Post>();
	int index = 0;
	Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
	while (postIterator.hasNext() && index < cantidad) {
		ultimosPosts.add(postIterator.next());
	}
	return ultimosPosts;
}

public void postOtrosUsuarios(List<Post> postsOtrosUsuarios ,Usuario user){
	
	for (Post post : this.posts) {
		if (!post.getUsuario().equals(user)) {
			postsOtrosUsuarios.add(post);
		}
	}
}

public void ordenarPostPorFecha(List<Post> postsOtrosUsuarios) {
	// ordena los posts por fecha
		for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
			int masNuevo = i;
			for (int j = i + 1; j < postsOtrosUsuarios.size(); j++) {// se deberia refactorizar este for con el if tambien ?
				if (postsOtrosUsuarios.get(j).getFecha().isAfter(postsOtrosUsuarios.get(masNuevo).getFecha())) {
					masNuevo = j;
				}
			}
			Post unPost = postsOtrosUsuarios.set(i, postsOtrosUsuarios.get(masNuevo));
			postsOtrosUsuarios.set(masNuevo, unPost);
		}
}

/**(i) El nombre del metodo es poco descriptivo ya que el mismo devuelvo los post que no son del usuario pasado por parametro,
(ii) Rename Method
(iii) Resolucion --> public List<Post> postOtrosUsuarios(Usuario user, int cantidad)
*/
