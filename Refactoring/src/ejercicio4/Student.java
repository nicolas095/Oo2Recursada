package ejercicio4;

import java.util.Vector;
import java.util.Iterator;

class Student {
	class ClassTaken {
		String name;
		Boolean done;
		int grade;

		public ClassTaken(String aName) {
			name = aName;
			done = false;
			grade = 0;
		}
	}

	String name;
	private Vector<ClassTaken> classes; // plan de estudio
	String id;

	public Student(String newName, String ident) {
		name = newName;
		id = ident;
		classes = new Vector<ClassTaken>();
	}

	void addClass(String name) {
		classes.add(new ClassTaken(name));
	}

	void addDoneClass(String name) {
		ClassTaken aClass = new ClassTaken(name);
		aClass.done = true;
		classes.add(aClass);
	}

	void addGradedClass(String name, int grade) {
		ClassTaken aClass = new ClassTaken(name);
		aClass.done = true;
		aClass.grade = grade;
		classes.add(aClass);
	}

	float finalsOverTaken() {
		int finals = 0;
		int done = 0;
		ClassTaken taken;
		Iterator it = classes.iterator();
		while (it.hasNext()) {
			taken = (ClassTaken) it.next();
			if (taken.done)
				done++;
			if (taken.grade >= 6)
				finals++;
		}
		return (float) finals / done;
	}

	boolean fitForScolarship() {
		int tally = 0;
		Iterator it = classes.iterator();
		ClassTaken taken;
		while (it.hasNext()) {
			taken = (ClassTaken) it.next();
			if (taken.grade >= 4)
				tally++;
		}
		return ((float) tally / classes.size() > 0.5) && (this.finalsOverTaken() > 0.66);
	}
}

/**
 * Inciso 2
 * 
 * Debe haber aprobado al menos el 50% de las clases.
   Debe tener un historial de finales aprobados en al menos el 66% de las clases hechas.
 */

/**
 * Inciso 3 - A
 * En el punto 1 hay refactoring ya que cambia el nombre del metodo usando Rename Method.
 * Para el punto 2 y 3 se usa refactoring a traves de un Extract Method ya que crea un nuevo metodo para reemplazar
 * el valor constante del condicional.
 */

