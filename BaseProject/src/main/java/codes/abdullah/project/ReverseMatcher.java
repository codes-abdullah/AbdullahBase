package codes.abdullah.project;

import java.util.Stack;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class ReverseMatcher {
	private final Matcher _matcher;
	private final Stack<MatchResult> _results = new Stack<>();

	public ReverseMatcher(Matcher matcher) {
		_matcher = matcher;
	}

	public boolean find() {
		return find(_matcher.regionEnd());
	}

	public boolean find(int start) {
		if (_results.size() > 0) {
			_results.pop();
			return _results.size() > 0;
		}
		boolean res = false;
		while (_matcher.find()) {
			if (_matcher.end() > start)
				break;
			res = true;
			_results.push(_matcher.toMatchResult());
		}
		return res;
	}

	public String group(int group) {
		return _results.peek().group(group);
	}

	public String group() {
		return _results.peek().group();
	}

	public int start() {
		return _results.peek().start();
	}

	public int end() {
		return _results.peek().end();
	}


}
