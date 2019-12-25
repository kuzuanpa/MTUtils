package exterminatorJeff.undergroundBiomes.api;

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
abstract public interface UndergroundBiomeSetProvider {
    // this function should return the new desired set
    // if null is returned that signals no changes to the existing set
     public UndergroundBiomeSet modifiedBiomeSet(int dimension, long worldSeed, UndergroundBiomeSet previous);
}
