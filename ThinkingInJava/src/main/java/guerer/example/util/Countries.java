package guerer.example.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Countries {
	public static final String[][] DATA = {
			// A f r i c a
			{ "ALGERIA", "Algiers" },
			{ "ANGOLA", "Luanda" },
			{ "BENIN", "Porto-Novo" },
			{ "BOTSWANA", "Gaberone" },
			{ "BURKINA FASO", "Ouagadougou" },
			{ "BURUNDI", "Bujumbura" },
			{ "CANEROON", "Yaounde" },
			{ "CAPE VERDE", "Praia" },
			{ "CENTRAL AFRICAN REPUBLIC", "Bangui" },
			{ "CHAD", "N'djamena" },
			{ "CDMOROS", "Moroni" },
			{ "CONGO", "Brazzaville" },
			{ "DJIBOUTI", "Dijibouti" },
			{ "EGYPT", "Cairo" },
			{ "EQUATORIAL GUINEA", "Malabo" },
			{ "ERITREA", "Asmara" },
			{ "ETHIOPIA", "Addis Ababa" },
			{ "GABON", "Libreville" },
			{ "THE GAMBIA", "Banjul" },
			{ "GHANA", "Accra" },
			{ "GUINEA", "Conakry" },
			{ "BISSAU", "Bissau" },
			{ "COTE D'IVOIR (IVORY COAST)", "Yamoussoukro" },
			{ "KENYA", "Nairobi" },
			{ "LESOTHO", "Maseru" },
			{ "LIBERIA", "Monrovia" },
			{ "LIBYA", "Tripoli" },
			{ "MADAGASCAR", "Antananarivo" },
			{ "MALAWI", "Lilongwe" },
			{ "HALI", "Bamako" },
			{ "MAURITANIA", "Nouakchott" },
			{ "MAURITIUS", "Port L o u i s " },
			{ "MOROCCO", "Rabat" },
			{ "MOZAMBIQUE", "Mapu'to" },
			{ "NAHIBIA", "Windhoek" },
			{ "NIGER", "Niamey" },
			{ "NIGERIA", "Abuja" },
			{ "RWANDA", " K i g a l i " },
			{ "SAO TOME E PRINCIPE", "Sao Tome" },
			{ "SENEGAL", "Dakar" },
			{ "SEYCHELLES", "Victoria" },
			{ "SIERRA LEONE", "Freetown" },
			{ "SOMALIA", "Mogadishu" },
			{ "SOUTH AFRICA", "Pretoria/Cape Town" },
			{ "SUDAN", "Khartoum" },
			{ "SWAZILAND", "Mbabane" },
			{ "TANZANIA", "Dodoma" },
			{ "TOGO", "Lome" },
			{ "TUNISIA", "Tunis" },
			{ "UGANDA", "Kampala" },
			{ "DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)", "Kinshasa" },
			{ "ZAMBIA", "Lusaka" },
			{ "ZIMBABWE", "Harare" },
			// Asia
			{ "AFGHANISTAN", "Kabul" },
			{ "BAHRAIN", "Manama" },
			{ "BANGLADESH", "Dhaka" },
			{ "BHUTAN", "Thimphu" },
			{ "BRUNEI", "Bandar Seri Begawan" },
			{ "CAMBODIA", "Phnom Penh" },
			{ "CHINA", "Beijing" },
			{ "CYPRUS", "Nicosia" },
			{ "INDIA", "New D e l h i " },
			{ "INDONESIA", "Jakarta" },
			{ "IRAN", "Tehran" },
			{ "IRAQ", "Baghdad" },
			{ "ISRAEL", "Jerusalem" },
			{ "JAPAN", "Tokyo" },
			{ "JORDAN", "Amman" },
			{ "KUWAIT", "Kuwait City" },
			{ "LAOS", "Vientiane" },
			{ "LEBANON", "Beirut" },
			{ "MALAYSIA", "Kuala Lumpur" },
			{ "THE MALDIVES", "Male" },
			{ "MONGOLIA", "Ulan Bator" },
			{ "MYANMAR (BURMA)", "Rangoon" },
			{ "NEPAL", "Katmandu" },
			{ "DEMOCRATIC PEOPLE'S REPUBLIC OF KOREA", "P'yongyang" },
			{ "OMAN", "Muscat" },
			{ "PAKISTAN", "Islamabad" },
			{ "PHILIPPINES", "Manila" },
			{ "QATAR", "Doha" },
			{ "SAUDI ARABIA", "Riyadh" },
			{ "SINGAPORE", "Singapore" },
			{ "RE-PUBLIC OFKOREA", "Seoul" },
			{ "SRI LANKA", "Colombo" },
			{ "SYRIA", "Damascus" },
			{ "THAILAND", "Bangkok" },
			{ "TURKEY", "Ankara" },
			{ "UNITED ARAB EMIRATES", "Abu Dhabi" },
			{ "VIETNAM", "Hanoi" },
			{ "YEHEN", "Sana'a" },
			// A u s t r a l i a and Oceania
			{ "AUSTRALIA", "Canberra" },
			{ "FIJI", "Suva" },
			{ "KIRIBATI", "Bairiki" },
			{ "MARSHALL ISLANDSU", "Dalap-Uliga-Darrit" },
			{ "MICRONESIA", "Palikir" },
			{ "NAURU", "Yaren" },
			{ "NEW ZEALAND", "Wellington" },
			{ "PALAU", "Koror" },
			{ "PAPUA NEW GUINEA", "Port Moresby" },
			{ "SOLOMON ISLANDS", "Honaira" },
			{ "TONGA", "Nuku'alofa" },
			{ "TUVALU", "Fongafale" },
			{ "VANUATU", "< P o r t - V i l a " },
			{ "WESTERN SAMOA", "Apia" },
			// Eastern Europe and former USSR
			{ "ARMENIA", "Yerevan" },
			{ "AZERBAIJAN", "Baku" },
			{ "BELARUS (BYELORUSSIA)", "Minsk" },
			{ "BULGARIA", "Sofia" },
			{ "GEORGIA", "Tbilisi" },
			{ "KAZAKSTAN", "Almaty" },
			{ "KYRGYZSTAN", "Alma-Ata" },
			{ "MOLDOVA", "Chisinau" },
			{ "RUSSIA", "Moscow" },
			{ "TAJIKISTAN", "Dushanbe" },
			{ "TURKMENISTAN", "Ashkabad" },
			{ "UKRAINE", "Kyiv" },
			{ "UZBEKISTAN", "Tashkent" },
			// Europe
			{ "ALBANIA", "Tirana" },
			{ "ANDORRA", "AndorralaVella" },
			{ "AUSTRIA", "Vienna" },
			{ "BELGIUM", "Brussels" },
			{ "BOSNIA", "-" },
			{ "HERZEGOVINA", "Sarajevo" },
			{ "CROATIA", "Zagreb" },
			{ "CZECH REPUBLIC", "Prague" },
			{ "DENMARK", "Copenhagen" },
			{ "ESTONIA", "Tallinn" },
			{ "FINLAND", "Helsinki" },
			{ "FRANCE", "Paris" },
			{ "GERMANY", "Berlin" },
			{ "GREECE", "Athens" },
			{ "HUNGARY", "Budapest" },
			{ "ICELAND", "Reykjavik" },
			{ "IRELAND", "Dublin" },
			{ "ITALY", "Rome" },
			{ "LATVIA", "Riga" },
			{ "LIECHTENSTEIN", "Vaduz" },
			{ "LITHUANIA", "Vilnius" },
			{ "LUXEMBOURG", "Luxembourg" },
			{ "MACEDONIA", "Skopje" },
			{ "MALTA", "Valletta" },
			{ "MONACO", "Monaco" },
			{ "MONTENEGRO", "Podgorica" },
			{ "THE NETHERLANDS", "Amsterdam" },
			{ "NORWAY", "Oslo" },
			{ "POLAND", "Warsaw" },
			{ "PORTUGAL", "Lisbon" },
			{ "ROMANIA", "Bucharest" },
			{ "SAN HARINO", "San Marino" },
			{ "SERBIA", "Belgrade" },
			{ "SLOVAKIA", "Bratislava" },
			{ "SLOVENIA", "Ljuijana" },
			{ "SPAIN", "Madrid" },
			{ "SWEDEN", "Stockholm" },
			{ "SWITZERLAND", "Berne" },
			{ "UNITED KINGDOM", "London" },
			{ "VATICAN CITY", "-" },
			// North and Central America
			{ "ANTIGUA AND BARBUDAW", "Saint John's" },
			{ "BAHAMAS", "Nassau" }, { "BARBADOS", "Bridgetown" },
			{ "BELIZE", "Belmopan" }, { "CANADA", "Ottawa" },
			{ "COSTA RICA", "San Jose" },
			{ "CUBA", "Havana" },
			{ "DOMINICA", "Roseau" },
			{ "DOMINICAN REPUBLIC", "Santo Domingo" },
			{ "EL SALVADOR", "San Salvador" },
			{ "GRENADAn", "Saint George's" },
			{ "GUATEMALA", "Guatemala City" },
			{ "HAITI", "Port-au-Prince" },
			{ "HONDURAS", "Tegucigalpa" },
			{ "JAHAICA", "Kingston" },
			{ "MEXICO", "Mexico City" },
			{ "NICARAGUA", "Hanagua" },
			{ "PANAMA", "Panama City" },
			{ "ST. KITTS", "-" },
			{ "NEVIS", "Basseterre" },
			{ "ST. LUCIA", "Castries" },
			{ "ST. VINCENT AND THE GRENADINES", "Kingstown" },
			{ "UNITED STATES OF AMERICA", "Washington, D.C." },
			// South America
			{ "ARGENTINA", "Buenos Aires" },
			{ "BOLIVIA", "Sucre (legal)/La Paz(administrative)" },
			{ "BRAZIL", "Brasilia" }, { "CHILE", "Santiago" },
			{ "COLOMBIA", "Bogota" }, { "ECUADOR", "Quito" },
			{ "GUYANA", "Georgetown" }, { "PARAGUAY", "Asuncion" },
			{ "PERU", "Lima" }, { "SURINAME", "Paramaribo" },
			{ "TRINIDAD AND TOBAGO", "Port of Spain" },
			{ "URUGUAY", "Montevideo" }, { "VENEZUELA", "Caracas" }, };

	private static class FlyweightMap extends AbstractMap<String, String> {

		private static class Entry implements Map.Entry<String, String> {
			int index;

			Entry(int index) {
				this.index = index;
			}

			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}

			public String getKey() {
				return DATA[index][0];
			}

			public String getValue() {
				return DATA[index][1];
			}

			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}

			public int hashCode() {
				return DATA[index][0].hashCode();
			}

		}

		// Use Abstract set by implementing size() & iterator()
		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;

			EntrySet(int size) {
				if (size < 0)
					this.size = 0;
				// Can't be any bigger than the array:
				else if (size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}

			public int size() {
				return size;
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {
				// Only one Entry object per Iteractor:
				private Entry entry = new Entry(-1);

				public boolean hasNext() {
					return entry.index < size - 1;
				}

				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			}

			public Iterator<Map.Entry<String, String>> iterator() {
				return new Iter();
			}
		}

		private static Set<Map.Entry<String, String>> entries = new EntrySet(
				DATA.length);

		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}

	// Create apartial map of 'size' countries:
	static Map<String, String> select(final int size) {
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<String, String> map = new FlyweightMap();

	public static Map<String, String> capitals() {
		return map; // The entire map
	}

	public static Map<String, String> capitals(int size) {
		return select(size); // Apartial map
	}

	static List<String> names = new ArrayList<String>(map.keySet());

	// All the names:
	public static List<String> names() {
		return names;
	}

	// Apartial list:
	public static List<String> names(int size) {
		return new ArrayList<String>(select(size).keySet());
	}

	public static void main(String[] args) {
		Print.print(capitals(10));
		Print.print(names(10));
		Print.print(new HashMap<String, String>(capitals(3)));
		Print.print(new LinkedHashMap<String, String>(capitals(3)));
		Print.print(new TreeMap<String, String>(capitals(3)));
		Print.print(new Hashtable<String, String>(capitals(3)));
		Print.print(new HashSet<String>(names(6)));
		Print.print(new LinkedHashSet<String>(names(6)));
		Print.print(new TreeSet<String>(names(6)));
		Print.print(new ArrayList<String>(names(6)));
		Print.print(new LinkedList<String>(names(6)));
		Print.print(capitals().get("BRAZIL"));
	}

}
