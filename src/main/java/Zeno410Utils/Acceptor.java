
package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

/**
 *
 * @author Zeno410
 */
public abstract class Acceptor<Type> {
    public abstract void accept(Type accepted);

    public static class Ignorer<IgnoredType> extends Acceptor<IgnoredType> {
        public void accept(IgnoredType ignored) {}
    }

    public static class OneShotRedirector<RedirectedType> extends Acceptor<RedirectedType> {
        private Acceptor<RedirectedType> target;
        public void accept(RedirectedType redirected) {
            target.accept(redirected);
            target = null;
        }
        public void redirectTo(Acceptor<RedirectedType> newTarget) {
            target = newTarget;
        }
    }
}
