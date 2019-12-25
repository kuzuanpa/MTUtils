package exterminatorJeff.undergroundBiomes.api;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

public class StrataLayer{
    public final NamedBlock layerBlock;
    public final int layerMetadataID, layerMin, layerMax;
    public final UBStoneCodes codes;

    public StrataLayer(NamedBlock layerBlock, int layerMetadataID, int layerMin, int layerMax){
        this.layerBlock = layerBlock;
        this.layerMetadataID = layerMetadataID;
        this.layerMin = layerMin;
        this.layerMax = layerMax;
        this.codes = new UBStoneCodes(layerBlock, layerMetadataID);
    }

    public boolean valueIsInLayer(int y){
        if(y >= layerMin && y <= layerMax){
            return true;
        }else{
            return false;
        }
    }

}
