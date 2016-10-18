package sample.versioncheck.strategy;

import java.util.Map;

/**
 * Gives access to the various strategies. The implementation of this
 * API must collect the Strategies registered in Plexus and return them
 * by name or as list.
 */
public interface StrategyProvider
{
    String ROLE = StrategyProvider.class.getName();

    Strategy forName(String name);

    Map getStrategies();
}
