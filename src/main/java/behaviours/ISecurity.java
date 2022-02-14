package behaviours;

import people.Visitor;

public interface ISecurity {
    boolean isAllowedTO(Visitor visitor);
}
