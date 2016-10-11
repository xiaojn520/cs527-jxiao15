package sample.versioncheck.version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class VersionResolution
{
    private final String dependentName;
    private final String dependencyName;
    private final Version expectedVersion;
    private final Version actualVersion;
    private final boolean directDependency;

    private boolean conflict = false;

    public VersionResolution(final String dependentName,
        final String dependencyName,
        final Version expectedVersion,
        final Version actualVersion,
        final boolean directDependency)
    {
        this.dependentName = dependentName;
        this.dependencyName = dependencyName;
        this.expectedVersion = expectedVersion;
        this.actualVersion = actualVersion;
        this.directDependency = directDependency;
    }


    public String getDependentName()
    {
        return dependentName;
    }

    public String getDependencyName()
    {
        return dependencyName;
    }


    public Version getExpectedVersion()
    {
        return expectedVersion;
    }

    public Version getActualVersion()
    {
        return actualVersion;
    }

    /**
     * Returns true if this dependency is a "direct" dependency of the project.
     */
    public boolean isDirectDependency()
    {
        return directDependency;
    }

    public void setConflict(final boolean conflict)
    {
        this.conflict = conflict;
    }

    public boolean isConflict()
    {
        return conflict;
    }

    public boolean equals(final Object other)
    {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }

        if (other == this) {
            return true;
        }

        VersionResolution castOther = (VersionResolution) other;
        return new EqualsBuilder().append(dependentName, castOther.dependentName)
            .append(dependencyName, castOther.dependencyName)
            .append(expectedVersion, castOther.expectedVersion)
            .append(actualVersion, castOther.actualVersion)
            .append(conflict, castOther.conflict)
            .isEquals();
    }

    public int hashCode()
    {
        return new HashCodeBuilder().append(dependentName).append(dependencyName).append(expectedVersion).append(actualVersion).append(conflict).toHashCode();
    }

    public String toString()
    {
        return new ToStringBuilder(this).append("dependentName", dependentName)
            .append("dependencyName", dependencyName)
            .append("expectedVersion", expectedVersion)
            .append("actualVersion", actualVersion)
            .append("isConflict", conflict)
            .toString();
    }


}
