package sample.versioncheck.util;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;

/**
 * Excludes or includes optional artifacts. If the optional argument on the c'tor is true,
 * allow optional artifacts, otherwise drop them.
 */
public class ArtifactOptionalFilter implements ArtifactFilter
{
    private final boolean optional;

    public ArtifactOptionalFilter(final boolean optional)
    {
        this.optional = optional;
    }

    public boolean include(final Artifact artifact)
    {
        if (artifact.isOptional()) {
            return optional;
        }
        else {
            return true;
        }
    }
}

