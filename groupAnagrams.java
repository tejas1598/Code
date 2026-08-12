public List<List<String>> builder(String[] strs)
    {
        Map<String, List<String>> keyMap = new HashMap<>();

        for(String a : strs)
        {        
            Map<Character, Integer> map = new HashMap<>();
            
            char[] word = a.toCharArray();

            for(char y : word)
            {
                if(map.containsKey(y))
                {
                    map.put(y, map.get(y)+1);
                }
                else
                {
                    map.put(y,1);
                }
            }

            StringBuilder key = new StringBuilder();

            for(char e = 'a' ; e <= 'z' ; e++)
            {
                if(map.containsKey(e))
                {
                    key.append(map.get(e)).append("#");
                }
                else
                {
                    key.append(00).append("#");
                }
            }

            if(keyMap.containsKey(key.toString()))
            {
                keyMap.get(key.toString()).add(a);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(a);

                keyMap.put(key.toString(), list);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        keyMap.values().forEach( value -> answer.add(value));

        return answer;
    }
