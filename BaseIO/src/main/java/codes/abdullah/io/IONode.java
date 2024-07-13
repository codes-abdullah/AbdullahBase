package codes.abdullah.io;

import codes.abdullah.io.attribute.IOAttributes;

public interface IONode {
	IOAttributes getAttributes();

	IOPath getPath();

	IODir getParent();

	IODir getParentAt(int index);

	IODir getRoot();

	IONode sub(int from, int to);
}
