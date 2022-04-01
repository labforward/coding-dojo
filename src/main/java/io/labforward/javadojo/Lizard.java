package io.labforward.javadojo;

import java.util.List;

class Sizor implements Form {

	@Override
	public List<? extends Form> beat() {
		return List.of(new Paper());

	}

}
