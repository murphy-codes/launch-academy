import Fox from '../Fox.js'

describe('A Fox', () => {
  let fox
  let foxName

  beforeEach(() => {
    foxName = 'Kit'
    fox = new Fox(foxName)
  })

  it('has a name', () => {
    expect(fox.name).toEqual(foxName)
  })

  it('says what foxes say', () => {
    expect(fox.speak()).toEqual('Ring-ding-ding-ding-dingeringeding!')
  })

  it("makes sure you haven't hardcoded the name", () => {
    let newFox = new Fox('Robin Hood')
    expect(newFox.name).toEqual('Robin Hood')
  })
})
