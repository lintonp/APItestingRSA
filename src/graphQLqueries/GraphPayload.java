package graphQLqueries;

public class GraphPayload {
	public static String getMutationCreateLocationAndEpisode(String locationName, String characterName) {
		return "{\"query\":\"# Welcome to GraphiQL\\n#\\n# GraphiQL is an in-browser tool for writing, validating, and\\n# testing GraphQL queries.\\n#\\n# Type queries into this side of the screen, and you will see intelligent\\n# typeaheads aware of the current GraphQL type schema and live syntax and\\n# validation errors highlighted within the text.\\n#\\n# GraphQL queries typically start with a \\\"{\\\" character. Lines that start\\n# with a # are ignored.\\n#\\n# An example GraphQL query might look like:\\n#\\n#     {\\n#       field(arg: \\\"value\\\") {\\n#         subField\\n#       }\\n#     }\\n#\\n# Keyboard shortcuts:\\n#\\n#  Prettify Query:  Shift-Ctrl-P (or press the prettify button above)\\n#\\n#     Merge Query:  Shift-Ctrl-M (or press the merge button above)\\n#\\n#       Run Query:  Ctrl-Enter (or press the play button above)\\n#\\n#   Auto Complete:  Ctrl-Space (or just start typing)\\n#\\n\\nmutation($locationName: String!, $characterName: String!){\\n  createLocation(location:{name: $locationName type:\\\"country\\\", dimension:\\\"400\\\"}){\\n    id\\n  }\\n  createEpisode(episode:{name:$characterName, air_date:\\\"today\\\", episode:\\\"The Jungle book today\\\"}){\\n    id\\n  }\\n}\\n\",\""
				+ "variables\":{\"locationName\":\""+locationName+"\",\"characterName\":\""+characterName+"\"}}";
	}
}
