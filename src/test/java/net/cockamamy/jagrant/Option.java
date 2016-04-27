package net.cockamamy.jagrant;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;

import static java.lang.String.*;
import static com.google.common.base.Preconditions.*;
import static com.google.common.base.Strings.*;

public final class Option {


    private final String myName;
    private final String myValue;

    public Option(final String aName, final String aValue) {

        super();

        checkArgument(!isNullOrEmpty(aName));
        checkArgument(aValue != null);

        myName = aName;
        myValue = aValue;

    }

    public Option(final String aName) {
        this(aName, "");
    }

    public String render() {

        final String theRenderedName = myName.length() == 1 ? "-" + myName : "--" + myName;
        return Joiner.on(" ").join(theRenderedName, myValue);

    }

    @Override
    public boolean equals(Object thatObject) {

        if (this == thatObject) {
            return true;
        }

        if (thatObject == null || getClass() != thatObject.getClass()) {
            return false;
        }

        final Option thatOption = (Option) thatObject;
        return Objects.equal(myName, thatOption.myName) &&
                Objects.equal(myValue, thatOption.myValue);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(myName, myValue);
    }

    @Override
    public String toString() {
        return format("Option: { name: %1$s, value: %2$s }", this.myName, this.myValue);
    }

    public String getName() {
        return myName;
    }

    public String getValue() {
        return myValue;
    }
}
