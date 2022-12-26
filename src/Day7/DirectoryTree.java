package Day7;

import java.util.HashSet;
import java.util.Set;

public class DirectoryTree {
    private String name;
    private int size;
    private DirectoryTree parent;
    private Set<DirectoryTree> children;

    public DirectoryTree(String name) {
        this.name = name;
        children = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public DirectoryTree getParent() {
        return this.parent;
    }

    public void setParent(DirectoryTree prnt) {
        this.parent = prnt;
    }

    public Set<DirectoryTree> getChildren() {
        return this.children;
    }

    public void setChildren(Set<DirectoryTree> chld) {
        this.children = chld;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int sz) {
        this.size = sz;
    }

    public int getDirSize() {
        int childDirSizes = 0;
        for (DirectoryTree childDir : this.getChildren()) {
            int childSize = childDir.getDirSize();
            childDirSizes += childSize;
        }
        return childDirSizes + this.getSize();
    }
}