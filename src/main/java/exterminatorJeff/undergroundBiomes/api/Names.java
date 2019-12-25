package exterminatorJeff.undergroundBiomes.api;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

public class Names {

    private final String internal;

    public Names(String internalName) {
        super();
        internal = internalName;
    }

    public final String internal() {
        return internal;
    }

    public final String external() {
        return UBIDs.publicName(internal);
    }

    public final String iconName() {
        return UBIDs.iconName(internal);
    }

    public final RuntimeException duplicateRegistry() {
        return new RuntimeException("duplication registry for Block " + external());
    }

    @Override
    public String toString() {return external();}
}
