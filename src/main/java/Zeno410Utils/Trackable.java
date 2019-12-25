
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
 *
 * IMPORTANT: Use of this interface implies a contract in which the implementing object will
 * remember its trackers and update them whenever it's changed. This is not an enforceable contract,
 * and if you don't follow it you get a obnoxious and hard-to-find fictitious implementation bug.
 */

public interface Trackable<Type> {
    public void informOnChange(Acceptor<Type> target);
    public void stopInforming(Acceptor<Type> target);
}
