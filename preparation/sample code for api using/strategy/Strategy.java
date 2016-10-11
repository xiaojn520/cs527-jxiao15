package sample.versioncheck.strategy;

import sample.versioncheck.version.Version;

/**
 * A strategy implementation decides whether two versions are compatible with each other.
 */
public interface Strategy
{
    /**
     * Returns the name of the strategy.
     */
    String getName();

    /**
     * Returns true if an artifact with Version b can be replaced by an artifact with Version a.
     */
    boolean isCompatible(Version a, Version b);
}

