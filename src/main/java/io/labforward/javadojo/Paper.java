package io.labforward.javadojo;

import java.util.List;

class Paper implements Form {

	@Override
	public List<? extends Form> beat() {
		return List.of(new Rock());

	}

}
