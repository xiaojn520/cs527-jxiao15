package sample.versioncheck.util;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Filter a given artifact based on a list of scopes. Only allow
 * inclusion if the artifact is in one of the scopes.
 */
public class ArtifactScopeFilter implements ArtifactFilter
{
    final String[] scopes;

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public ArtifactScopeFilter(final String[] scopes)
    {
        this.scopes = scopes;
    }

    public boolean include(Artifact artifact)
    {
        for (int i = 0; i < scopes.length; i++) {
            if (artifact.getScope().equals(scopes[i])) {
                return true;
            }
        }
        return false;
    }
}

