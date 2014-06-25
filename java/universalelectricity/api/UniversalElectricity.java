package universalelectricity.api;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * General Universal Electricity class.
 * 
 * @author Calclavia
 * 
 */
public class UniversalElectricity
{
	/**
	 * The version of the Universal Electricity API.
	 */
	public static final String MAJOR_VERSION = "3";
	public static final String MINOR_VERSION = "2";
	public static final String REVISION_VERSION = "0";
	public static final String BUILD_VERSION = "1";
	public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION;

	public static long DEFAULT_VOLTAGE = 240;

	/**
	 * A general material that can be used by machines. Breakable by hand, suitable for machines.
	 */
	public static final Material machine = new Material(MapColor.ironColor);
}
