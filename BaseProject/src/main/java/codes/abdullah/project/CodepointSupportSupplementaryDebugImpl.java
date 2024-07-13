package codes.abdullah.project;

final class CodepointSupportSupplementaryDebugImpl extends CodepointSupportSupplementaryImpl {
	static final int MIN = 65536, MAX = 74761;
	static final char MIN_HIGH = 'A', MAX_HIGH = 'Z';
	static final char MIN_LOW = '0', MAX_LOW = '9';
	static final int[] cps = { //
			65536, 65537, 65538, 65539, 65540, 65541, 65542, 65543, 65544, 65545, // A 0-9
			66560, 66561, 66562, 66563, 66564, 66565, 66566, 66567, 66568, 66569, // B 0-9
			67584, 67585, 67586, 67587, 67588, 67589, 67590, 67591, 67592, 67593, // C 0-9
			68608, 68609, 68610, 68611, 68612, 68613, 68614, 68615, 68616, 68617, // D 0-9
			69632, 69633, 69634, 69635, 69636, 69637, 69638, 69639, 69640, 69641, // E 0-9
			70656, 70657, 70658, 70659, 70660, 70661, 70662, 70663, 70664, 70665, // F 0-9
			71680, 71681, 71682, 71683, 71684, 71685, 71686, 71687, 71688, 71689, // G 0-9
			72704, 72705, 72706, 72707, 72708, 72709, 72710, 72711, 72712, 72713, // H 0-9
			73728, 73729, 73730, 73731, 73732, 73733, 73734, 73735, 73736, 73737, // I 0-9
			74752, 74753, 74754, 74755, 74756, 74757, 74758, 74759, 74760, 74761, // J 0-9
			75776, 75777, 75778, 75779, 75780, 75781, 75782, 75783, 75784, 75785, // K 0-9
			76800, 76801, 76802, 76803, 76804, 76805, 76806, 76807, 76808, 76809, // L 0-9
			77824, 77825, 77826, 77827, 77828, 77829, 77830, 77831, 77832, 77833, // M 0-9
			78848, 78849, 78850, 78851, 78852, 78853, 78854, 78855, 78856, 78857, // N 0-9
			79872, 79873, 79874, 79875, 79876, 79877, 79878, 79879, 79880, 79881, // O 0-9
			80896, 80897, 80898, 80899, 80900, 80901, 80902, 80903, 80904, 80905, // P 0-9
			81920, 81921, 81922, 81923, 81924, 81925, 81926, 81927, 81928, 81929, // Q 0-9
			82944, 82945, 82946, 82947, 82948, 82949, 82950, 82951, 82952, 82953, // R 0-9
			83968, 83969, 83970, 83971, 83972, 83973, 83974, 83975, 83976, 83977, // S 0-9
			84992, 84993, 84994, 84995, 84996, 84997, 84998, 84999, 85000, 85001, // T 0-9
			86016, 86017, 86018, 86019, 86020, 86021, 86022, 86023, 86024, 86025, // U 0-9
			87040, 87041, 87042, 87043, 87044, 87045, 87046, 87047, 87048, 87049, // V 0-9
			88064, 88065, 88066, 88067, 88068, 88069, 88070, 88071, 88072, 88073, // W 0-9
			89088, 89089, 89090, 89091, 89092, 89093, 89094, 89095, 89096, 89097, // X 0-9
			90112, 90113, 90114, 90115, 90116, 90117, 90118, 90119, 90120, 90121, // Y 0-9
			91136, 91137, 91138, 91139, 91140, 91141, 91142, 91143, 91144, 91145, // Z 0-9
	};

	@Override
	public boolean isPair(int cp) {
		return (cp >= 65536 && cp <= 65545) || // A 0-9
				(cp >= 66560 && cp <= 66569) || // B 0-9
				(cp >= 67584 && cp <= 67593) || // C 0-9
				(cp >= 68608 && cp <= 68617) || // D 0-9
				(cp >= 69632 && cp <= 69641) || // E 0-9
				(cp >= 70656 && cp <= 70665) || // F 0-9
				(cp >= 71680 && cp <= 71689) || // G 0-9
				(cp >= 72704 && cp <= 72713) || // H 0-9
				(cp >= 73728 && cp <= 73737) || // I 0-9
				(cp >= 74752 && cp <= 74761) || // J 0-9
				(cp >= 75776 && cp <= 75785) || // K 0-9
				(cp >= 76800 && cp <= 76809) || // L 0-9
				(cp >= 77824 && cp <= 77833) || // M 0-9
				(cp >= 78848 && cp <= 78857) || // N 0-9
				(cp >= 79872 && cp <= 79881) || // O 0-9
				(cp >= 80896 && cp <= 80905) || // P 0-9
				(cp >= 81920 && cp <= 81929) || // Q 0-9
				(cp >= 82944 && cp <= 82953) || // R 0-9
				(cp >= 83968 && cp <= 83977) || // S 0-9
				(cp >= 84992 && cp <= 85001) || // T 0-9
				(cp >= 86016 && cp <= 86025) || // U 0-9
				(cp >= 87040 && cp <= 87049) || // V 0-9
				(cp >= 88064 && cp <= 88073) || // W 0-9
				(cp >= 89088 && cp <= 89097) || // X 0-9
				(cp >= 90112 && cp <= 90121) || // Y 0-9
				(cp >= 91136 && cp <= 91145) // Z 0-9
		;
	}

	@Override
	public boolean isValid(int cp) {
		return isBmp(cp) || isPair(cp);
	}

	@Override
	public boolean isPair(int high, int low) {
		return isHigh(high) && isLow(low);
	}

	@Override
	public boolean isHigh(int ch) {
		return (ch >= MIN_HIGH && ch <= MAX_HIGH);
	}

	@Override
	public boolean isLow(int ch) {
		return (ch >= MIN_LOW && ch <= MAX_LOW);
	}

	@Override
	public char toHigh(int cp) {
		if (!isPair(cp))
			return super.toHigh(cp);
		return (char) ((super.toHigh(cp) - MIN_HIGH_SURROGATE) + MIN_HIGH);
	}

	@Override
	public char toLow(int cp) {
		if (!isPair(cp))
			return super.toLow(cp);
		return (char) ((super.toLow(cp) - MIN_LOW_SURROGATE) + MIN_LOW);
	}

	@Override
	public int toCodepoint(char high, char low) {
		high = isHigh(high) ? (char) (high - MIN_HIGH + MIN_HIGH_SURROGATE) : high;
		low = isLow(low) ? (char) (low - MIN_LOW + MIN_LOW_SURROGATE) : low;
		return super.toCodepoint(high, low);
	}

	@Override
	public int toLowerCase(int cp) {
		if (isPair(cp)) {
			return cp;
		}
		return super.toLowerCase(cp);
	}

	@Override
	public int toUpperCase(int cp) {
		if (isPair(cp)) {
			return cp;
		}
		return super.toUpperCase(cp);
	}

}
