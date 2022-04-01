package io.labforward.javadojo;

import java.util.List;

class Rock implements Form {

	@Override
	public List<? extends Form> beat() {
		return List.of(new Sizor());

	}
}
