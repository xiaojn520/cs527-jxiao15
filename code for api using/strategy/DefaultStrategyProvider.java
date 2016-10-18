package sample.versioncheck.strategy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation for {@link sample.versioncheck.strategy.StrategyProvider}.
 *
 * @plexus.component role="sample.versioncheck.strategy.StrategyProvider"
 */
public class DefaultStrategyProvider implements StrategyProvider
{
    private static final Logger LOG = LoggerFactory.getLogger(DefaultStrategyProvider.class);

    /**
     * @plexus.requirement role="sample.versioncheck.strategy.Strategy"
     */
    protected List resolverDefinitions;

    private Map resolvers = null;

    public Map getStrategies()
    {
        if (resolvers == null) {
            Map newResolvers = new HashMap();
            if (!CollectionUtils.isEmpty(resolverDefinitions)) {
                for (Iterator it = resolverDefinitions.iterator(); it.hasNext();) {
                    final Strategy resolver = (Strategy) it.next();
                    final String name = resolver.getName().toLowerCase(Locale.ENGLISH);

                    LOG.debug("Adding {} as resolver.", name);
                    newResolvers.put(name, resolver);
                }
            }
            resolvers = newResolvers;
        }
        return resolvers;
    }

    public Strategy forName(final String name)
    {
        if (name == null) {
            return null;
        }
        final Map strategies = getStrategies();
        return (Strategy) strategies.get(name.toLowerCase(Locale.ENGLISH));
    }
}

