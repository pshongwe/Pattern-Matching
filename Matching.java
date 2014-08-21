// http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
// http://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html

import java.util.regex.*;

public class Matching
{
	public static void main(String args[])
	{
		String s = "Yesses No Yes";
		Pattern p = Pattern.compile("es");
		Matcher m = p.matcher(s);
		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("^es");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("es$");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("(.*)(Yes)");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<");
			System.out.println("$1: >" + m.group(1) + "<");
			System.out.println("$2: >" + m.group(2) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("(Yes)(.*)");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<");
			System.out.println("$1: >" + m.group(1) + "<");
			System.out.println("$2: >" + m.group(2) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("(Yes)(No)(Yes)");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Matched: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<");
			System.out.println("$1: >" + m.group(1) + "<");
			System.out.println("$2: >" + m.group(2) + "<");
			System.out.println("$3: >" + m.group(3) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("No");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("^(Ye)$");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<");
			System.out.println("$1: >" + m.group(1) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}

		p = Pattern.compile("[A-Za-z](s)");
		m = p.matcher(s);

		if (m.find())
		{
			System.out.println("Before: >" + s.substring(0,m.start()) + "<");
			System.out.println("Match: >" + m.group() + "<");
			System.out.println("After: >" + s.substring(m.end(), s.length()) + "<");
			System.out.println("$1: >" + m.group(1) + "<" + "\n");
		}
		else
		{
			System.out.println("Didn't match.\n");
		}


	}
}

/*

methods in Matcher class:
find, group, start, end, matches

===============

public boolean find()

Attempts to find the next subsequence of the input sequence that matches the pattern.

This method starts at the beginning of this matcher's region, or, if a previous invocation of the method was successful and the matcher has not since been reset, at the first character not matched by the previous match.

If the match succeeds then more information can be obtained via the start, end, and group methods.

Returns:
    true if, and only if, a subsequence of the input sequence matches this matcher's pattern

===============

public String group(int group)

Returns the input subsequence captured by the given group during the previous match operation.

For a matcher m, input sequence s, and group index g, the expressions m.group(g) and s.substring(m.start(g), m.end(g)) are equivalent.

Capturing groups are indexed from left to right, starting at one. Group zero denotes the entire pattern, so the expression m.group(0) is equivalent to m.group().

If the match was successful but the group specified failed to match any part of the input sequence, then null is returned. Note that some groups, for example (a*), match the empty string. This method will return the empty string when such a group successfully matches the empty string in the input.

Parameters:
    group - The index of a capturing group in this matcher's pattern
Returns:
    The (possibly empty) subsequence captured by the group during the previous match, or null if the group failed to match part of the input

==============

public int start()

Returns the start index of the previous match.

Specified by:
    start in interface MatchResult
Returns:
    The index of the first character matched

==============

public int end()

Returns the offset after the last character matched.

Specified by:
    end in interface MatchResult
Returns:
    The offset after the last character matched

==============

public boolean matches()

Attempts to match the entire region against the pattern.

If the match succeeds then more information can be obtained via the start, end, and group methods.

Returns:
    true if, and only if, the entire region sequence matches this matcher's pattern

===============


*/


/*

if ($s =~ m/es/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/^es/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/es$/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/(.*)(Yes)/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
	print "\$1: >$1<\n";
	print "\$2: >$2<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/(Yes)(.*)/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
	print "\$1: >$1<\n";
	print "\$2: >$2<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/(Yes)(No)(Yes)/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
	print "\$1: >$1<\n";
	print "\$2: >$2<\n";
	print "\$3: >$3<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m#No#)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/^(Ye)$/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
	print "\$1: >$1<\n";
}
else
{
	print "Didn't match.\n";
}

if ($s =~ m/[A-Za-z](s)/)
{
	print "Before: >$`<\n";
	print "Match: >$&<\n";
	print "After: >$'<\n";
	print "\$1: >$1<\n";
}
else
{
	print "Didn't match.\n";
}


*/
